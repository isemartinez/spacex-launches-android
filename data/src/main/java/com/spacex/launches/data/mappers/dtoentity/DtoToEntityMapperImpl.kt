package com.spacex.launches.data.mappers.dtoentity

import com.spacex.launches.data.models.local.FlickrLinkEntity
import com.spacex.launches.data.models.local.LaunchCoreEntity
import com.spacex.launches.data.models.local.LaunchEntity
import com.spacex.launches.data.models.local.LaunchFailureEntity
import com.spacex.launches.data.models.local.LaunchFairingsEntity
import com.spacex.launches.data.models.local.LaunchLinksEntity
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.PatchLinkEntity
import com.spacex.launches.data.models.local.RedditLinkEntity
import com.spacex.launches.data.models.local.RocketEntity
import com.spacex.launches.data.models.remote.launches.FlickrLinkDto
import com.spacex.launches.data.models.remote.launches.LaunchCoreDto
import com.spacex.launches.data.models.remote.launches.LaunchDto
import com.spacex.launches.data.models.remote.launches.LaunchFailureDto
import com.spacex.launches.data.models.remote.launches.LaunchFairingsDto
import com.spacex.launches.data.models.remote.launches.LaunchLinksDto
import com.spacex.launches.data.models.remote.launches.PatchLinkDto
import com.spacex.launches.data.models.remote.launches.RedditLinkDto
import com.spacex.launches.data.models.remote.launchpad.LaunchPadDto
import com.spacex.launches.data.models.remote.rocket.RocketDto

internal class DtoToEntityMapperImpl : DtoToEntityMapper {
    override fun mapLaunches(launches: List<LaunchDto>): List<LaunchEntity> {
        return launches.map { launchDto ->
            with(launchDto) {
                LaunchEntity(
                    autoUpdate = autoUpdate,
                    capsules = capsules.joinToString(separator = ","),
                    crew = capsules.joinToString(separator = ","),
                    dateLocal = dateLocal,
                    datePrecision = datePrecision,
                    dateUnix = dateUnix,
                    dateUtc = dateUtc,
                    details = details,
                    flightNumber = flightNumber,
                    launchId = id,
                    launchLibraryId = launchLibraryId,
                    launchpadId = launchpad,
                    name = name,
                    net = net,
                    payloads = payloads.joinToString(separator = ","),
                    rocket = rocket,
                    ships = ships.joinToString(separator = ","),
                    staticFireDateUnix = staticFireDateUnix,
                    staticFireDateUtc = staticFireDateUtc,
                    success = success,
                    tbd = tbd,
                    upcoming = upcoming,
                    window = window
                )
            }
        }
    }

    override fun mapFailures(
        launchId: Long,
        failures: List<LaunchFailureDto>
    ): List<LaunchFailureEntity> {
        return failures.map { failure ->
            with(failure) {
                LaunchFailureEntity(
                    launchId = launchId,
                    time = time,
                    altitude = altitude,
                    reason = reason
                )
            }
        }
    }

    override fun mapLinks(launchId: Long, launchLinks: LaunchLinksDto?): LaunchLinksEntity? {
        return launchLinks?.let {
            with(it) {
                LaunchLinksEntity(
                    launchId = launchId,
                    presskitUrl = presskit,
                    webcastUrl = webcast,
                    youtubeId = youtubeId,
                    articleUrl = article,
                    wikipediaUrl = wikipedia
                )
            }
        }
    }

    override fun mapPatchLink(launchLinksId: Long, patchLink: PatchLinkDto?): PatchLinkEntity? {
        return patchLink?.let {
            with(it) {
                PatchLinkEntity(
                    launchLinksId = launchLinksId,
                    small = small,
                    large = large
                )
            }
        }
    }

    override fun mapRedditLink(launchLinksId: Long, redditLink: RedditLinkDto?): RedditLinkEntity? {
        return redditLink?.let {
            with(it) {
                RedditLinkEntity(
                    launchLinksId = launchLinksId,
                    campaign = campaign,
                    launch = launch,
                    media = media,
                    recovery = recovery
                )
            }
        }
    }

    override fun mapFlickrLink(launchLinksId: Long, flickrLink: FlickrLinkDto?): FlickrLinkEntity? {
        return flickrLink?.let {
            with(it) {
                FlickrLinkEntity(
                    launchLinksId = launchLinksId,
                    small = small.joinToString(separator = ","),
                    original = original.joinToString(separator = ",")
                )
            }
        }
    }

    override fun mapCores(launchId: Long, cores: List<LaunchCoreDto>): List<LaunchCoreEntity> {
        return cores.map { core ->
            with(core) {
                LaunchCoreEntity(
                    launchId = launchId,
                    core = core.core,
                    flight = flight,
                    gridfins = gridfins,
                    legs = legs,
                    reused = reused,
                    landingAttempt = landingAttempt,
                    landingSuccess = landingSuccess,
                    landingType = landingType,
                    landpad = landpad
                )
            }
        }
    }

    override fun mapFairings(launchId: Long, fairings: LaunchFairingsDto?): LaunchFairingsEntity? {
        return fairings?.let {
            with(it) {
                LaunchFairingsEntity(
                    launchId = launchId,
                    reused = reused,
                    recoveryAttempt = recoveryAttempt,
                    recovered = recovered,
                    ships = ships.joinToString(separator = ",")
                )
            }
        }
    }

    override fun mapRocket(rocket: RocketDto?): RocketEntity? {
        return rocket?.let {
            with(it) {
                RocketEntity(
                    rocketId = id,
                    name = name,
                    type = type,
                    active = active,
                    country = country,
                    company = company,
                    wikipedia = wikipedia,
                    description = description
                )
            }
        }
    }

    override fun mapLaunchPad(launchPad: LaunchPadDto?): LaunchPadEntity? {
        return launchPad?.let {
            with(it) {
                LaunchPadEntity(
                    launchpadId = id,
                    details = details,
                    status = status,
                    launches = launches.joinToString(separator = ","),
                    timezone = timezone,
                    rockets = rockets.joinToString(separator = ","),
                    launchSuccesses = launchSuccesses,
                    launchAttempts = launchAttempts,
                    longitude = longitude,
                    latitude = latitude,
                    region = region,
                    locality = locality,
                    fullName = fullName,
                    name = name,
                    imageURL = images.large.first()
                )
            }
        }
    }
}