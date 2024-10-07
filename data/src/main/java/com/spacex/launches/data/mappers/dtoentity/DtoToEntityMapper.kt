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

internal interface DtoToEntityMapper {

    fun mapLaunches(launches: List<LaunchDto>): List<LaunchEntity>

    fun mapFailures(launchId: Long, failures: List<LaunchFailureDto>): List<LaunchFailureEntity>

    fun mapLinks(launchId: Long, launchLinks: LaunchLinksDto?): LaunchLinksEntity?

    fun mapPatchLink(launchLinksId: Long, patchLink: PatchLinkDto?): PatchLinkEntity?

    fun mapRedditLink(launchLinksId: Long, redditLink: RedditLinkDto?): RedditLinkEntity?

    fun mapFlickrLink(launchLinksId: Long, flickrLink: FlickrLinkDto?): FlickrLinkEntity?

    fun mapCores(launchId: Long, cores: List<LaunchCoreDto>): List<LaunchCoreEntity>

    fun mapFairings(launchId: Long, fairings: LaunchFairingsDto?): LaunchFairingsEntity?

    fun mapRocket(rocket: RocketDto?): RocketEntity?

    fun mapLaunchPad(launchPad: LaunchPadDto?): LaunchPadEntity?

}