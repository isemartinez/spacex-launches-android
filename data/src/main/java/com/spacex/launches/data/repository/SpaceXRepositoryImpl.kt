package com.spacex.launches.data.repository

import com.spacex.launches.data.api.SpaceXApiService
import com.spacex.launches.data.db.dao.FlickrLinkDao
import com.spacex.launches.data.db.dao.LaunchCoreDao
import com.spacex.launches.data.db.dao.LaunchDao
import com.spacex.launches.data.db.dao.LaunchFailureDao
import com.spacex.launches.data.db.dao.LaunchFairingsDao
import com.spacex.launches.data.db.dao.LaunchLinksDao
import com.spacex.launches.data.db.dao.LaunchPadDao
import com.spacex.launches.data.db.dao.PatchLinkDao
import com.spacex.launches.data.db.dao.RedditLinkDao
import com.spacex.launches.data.db.dao.RocketDao
import com.spacex.launches.data.mappers.dtoentity.DtoToEntityMapper
import com.spacex.launches.data.mappers.entitypresentation.EntityToPresentationMapper
import com.spacex.launches.data.models.local.LaunchEntityWrapper
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.RocketEntity
import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.remote.launches.FlickrLinkDto
import com.spacex.launches.data.models.remote.launches.LaunchCoreDto
import com.spacex.launches.data.models.remote.launches.LaunchDto
import com.spacex.launches.data.models.remote.launches.LaunchFailureDto
import com.spacex.launches.data.models.remote.launches.LaunchFairingsDto
import com.spacex.launches.data.models.remote.launches.LaunchLinksDto
import com.spacex.launches.data.models.remote.launches.LaunchQueryBody
import com.spacex.launches.data.models.remote.launches.PatchLinkDto
import com.spacex.launches.data.models.remote.launches.RedditLinkDto
import com.spacex.launches.data.states.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

internal class SpaceXRepositoryImpl(
    private val dtoToEntityMapper: DtoToEntityMapper,
    private val entityToPresentationMapper: EntityToPresentationMapper,
    private val apiService: SpaceXApiService,
    private val launchDao: LaunchDao,
    private val launchFailureDao: LaunchFailureDao,
    private val launchLinksDao: LaunchLinksDao,
    private val patchLinkDao: PatchLinkDao,
    private val redditLinkDao: RedditLinkDao,
    private val flickrLinkDao: FlickrLinkDao,
    private val launchCoreDao: LaunchCoreDao,
    private val launchFairingsDao: LaunchFairingsDao,
    private val rocketDao: RocketDao,
    private val launchPadDao: LaunchPadDao
) : SpaceXRepository {

    private suspend fun saveLaunchesToDB(launches: List<LaunchDto>): List<LaunchEntityWrapper> {
        return withContext(Dispatchers.IO) {
            launchDao.deleteLaunches()
            val launchesMapped = dtoToEntityMapper.mapLaunches(launches = launches)
            launchesMapped.forEachIndexed { index,launch->
                launch.launchId?.let {
                    launchDao.getLaunchByRemoteId(launch.launchId)?:run {
                        val launchId = launchDao.insertLaunch(launch = launch)
                        with(launches[index]){
                            saveFairingsToDB(launchId = launchId, fairings = fairings)
                            saveFailuresToDB(launchId = launchId, failures = failures)
                            saveLinksToDB(launchId = launchId, links = links)
                            saveCoresToDB(launchId = launchId, cores = cores)
                        }
                    }
                }
            }
            launchDao.getLaunches()
        }
    }

    private suspend fun saveFairingsToDB(launchId: Long, fairings: LaunchFairingsDto?) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapFairings(launchId = launchId, fairings = fairings)
                ?.let { launchFairingsDao.insertLaunchFairings(it) }
        }
    }

    private suspend fun saveFailuresToDB(launchId: Long, failures: List<LaunchFailureDto>) {
        withContext(Dispatchers.IO) {
            val failuresMapped =
                dtoToEntityMapper.mapFailures(launchId = launchId, failures = failures)
            launchFailureDao.insertLaunchFailures(launchFailures = failuresMapped)
        }
    }

    private suspend fun saveCoresToDB(launchId: Long, cores: List<LaunchCoreDto>) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapCores(launchId = launchId, cores = cores).let {
                launchCoreDao.insertLaunchCores(launchCores = it)
            }
        }
    }

    private suspend fun saveLinksToDB(launchId: Long, links: LaunchLinksDto?) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapLinks(launchId = launchId, launchLinks = links)?.let {
                    val launchLinksId = launchLinksDao.insertLaunchLinks(it)
                    savePatchLinkToDB(launchLinksId = launchLinksId, patchLink = links?.patch)
                    saveRedditLinkToDB(launchLinksId = launchLinksId, redditLink = links?.reddit)
                    saveFlickrLinkToDB(launchLinksId = launchLinksId, flickrLink = links?.flickr)
                }
        }
    }

    private suspend fun savePatchLinkToDB(launchLinksId: Long, patchLink: PatchLinkDto?) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapPatchLink(
                launchLinksId = launchLinksId, patchLink = patchLink
            )?.let {
                patchLinkDao.insertPatchLink(patchLink = it)
            }
        }
    }

    private suspend fun saveRedditLinkToDB(launchLinksId: Long, redditLink: RedditLinkDto?) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapRedditLink(
                launchLinksId = launchLinksId, redditLink = redditLink
            )?.let {
                redditLinkDao.insertRedditLink(redditLink = it)
            }
        }
    }

    private suspend fun saveFlickrLinkToDB(launchLinksId: Long, flickrLink: FlickrLinkDto?) {
        withContext(Dispatchers.IO) {
            dtoToEntityMapper.mapFlickrLink(
                launchLinksId = launchLinksId, flickrLink = flickrLink
            )?.let {
                flickrLinkDao.insertFlickrLink(flickrLink = it)
            }
        }
    }

    override suspend fun fetchLaunchesURL(): String {
        return "https://www.spacex.com/static/images/backgrounds/launches/launches_header_desktop.jpg"
    }

    override suspend fun fetchLaunchesByQueryFromAPI(query: LaunchQueryBody): Result<List<Launch>> {
        return withContext(Dispatchers.IO) {
            try {
                val launchQueryResponse = apiService.getLaunchesByQuery(query)
                val launchEntities = async { saveLaunchesToDB(launches = launchQueryResponse.docs) }.await()
                val launchesFromDB = launchEntities.map { launchEntityWrapper ->
                    val rocketId = launchEntityWrapper.launch.rocket
                    val rocket = fetchRocketById(id = rocketId)
                    val launchPadId = launchEntityWrapper.launch.launchpadId
                    val launchPad = fetchLaunchPadById(id = launchPadId)
                    entityToPresentationMapper.mapLaunch(launchEntityWrapper, rocket, launchPad)
                }
                Result.Success(launchesFromDB)
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }

    override suspend fun fetchLaunchesFromDB(): Result<List<Launch>> {
        return withContext(Dispatchers.IO) {
            val launches = launchDao.getLaunches()
            val result = launches.map { launchEntityWrapper->
                val rocketId = launchEntityWrapper.launch.rocket
                val rocket = fetchRocketById(id = rocketId)
                val launchPadId = launchEntityWrapper.launch.launchpadId
                val launchPad = fetchLaunchPadById(id = launchPadId)
                entityToPresentationMapper.mapLaunch(launchEntityWrapper, rocket, launchPad)
            }
            Result.Success(result)
        }
    }

    override suspend fun fetchLaunchById(id: Long): Launch? {
        return launchDao.getLaunchByLocalId(id = id)?.let {
            val rocketId = it.launch.rocket
            val rocket = fetchRocketById(id = rocketId)
            val launchPadId = it.launch.launchpadId
            val launchPad = fetchLaunchPadById(id = launchPadId)
            entityToPresentationMapper.mapLaunch(launchEntityWrapper = it, rocket, launchPad)
        }
    }

    private suspend fun fetchRocketById(id: String?): RocketEntity? {
        return withContext(Dispatchers.IO) {
            id?.let { rocketId ->
                rocketDao.getRocketById(rocketId) ?: run {
                    val response = apiService.getRocketById(rocketId)
                    dtoToEntityMapper.mapRocket(rocket = response)?.let {
                        it.copy(id = rocketDao.insertRocket(it))
                    }
                }
            }
        }
    }

    private suspend fun fetchLaunchPadById(id: String?): LaunchPadEntity? {
        return withContext(Dispatchers.IO) {
            id?.let { launchPadId ->
                val launchPad = launchPadDao.getLaunchPadById(launchPadId)
                launchPad ?: run {
                    val response = apiService.getLaunchPadById(launchPadId)
                    dtoToEntityMapper.mapLaunchPad(launchPad = response)?.let {
                        it.copy(id = launchPadDao.insertLaunchPad(it))
                    }
                }
            }
        }
    }
}
