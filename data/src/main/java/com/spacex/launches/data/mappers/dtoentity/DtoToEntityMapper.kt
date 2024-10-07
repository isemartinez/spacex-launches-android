package com.spacex.launches.data.mappers.dtoentity

import com.spacex.launches.data.models.local.*
import com.spacex.launches.data.models.remote.launches.*
import com.spacex.launches.data.models.remote.launchpad.LaunchPadDto
import com.spacex.launches.data.models.remote.rocket.RocketDto

/**
 * Interface that defines methods for mapping Data Transfer Objects (DTO) to local entities.
 * The goal of this interface is to convert data retrieved from remote sources (DTO) to local database entities
 * that are stored in the application's Room database.
 */
internal interface DtoToEntityMapper {

    /**
     * Maps a list of launch DTOs to a list of launch entities for local storage.
     *
     * @param launches A list of [LaunchDto] representing launches fetched from a remote source.
     * @return A list of [LaunchEntity] for local storage.
     */
    fun mapLaunches(launches: List<LaunchDto>): List<LaunchEntity>

    /**
     * Maps a list of launch failure DTOs to a list of launch failure entities associated with a specific launch.
     *
     * @param launchId The ID of the launch this failure is associated with.
     * @param failures A list of [LaunchFailureDto] representing launch failures.
     * @return A list of [LaunchFailureEntity] for local storage.
     */
    fun mapFailures(launchId: Long, failures: List<LaunchFailureDto>): List<LaunchFailureEntity>

    /**
     * Maps a launch links DTO to a launch links entity.
     *
     * @param launchId The ID of the launch this link is associated with.
     * @param launchLinks A [LaunchLinksDto] object representing links (e.g., Wikipedia, video, etc.) associated with a launch.
     * @return A [LaunchLinksEntity] for local storage, or null if the DTO is null.
     */
    fun mapLinks(launchId: Long, launchLinks: LaunchLinksDto?): LaunchLinksEntity?

    /**
     * Maps a patch link DTO to a patch link entity.
     *
     * @param launchLinksId The ID of the associated launch links.
     * @param patchLink A [PatchLinkDto] object representing patch image URLs.
     * @return A [PatchLinkEntity] for local storage, or null if the DTO is null.
     */
    fun mapPatchLink(launchLinksId: Long, patchLink: PatchLinkDto?): PatchLinkEntity?

    /**
     * Maps a Reddit link DTO to a Reddit link entity.
     *
     * @param launchLinksId The ID of the associated launch links.
     * @param redditLink A [RedditLinkDto] object representing Reddit-related links (e.g., campaign, launch, recovery).
     * @return A [RedditLinkEntity] for local storage, or null if the DTO is null.
     */
    fun mapRedditLink(launchLinksId: Long, redditLink: RedditLinkDto?): RedditLinkEntity?

    /**
     * Maps a Flickr link DTO to a Flickr link entity.
     *
     * @param launchLinksId The ID of the associated launch links.
     * @param flickrLink A [FlickrLinkDto] object representing Flickr image URLs.
     * @return A [FlickrLinkEntity] for local storage, or null if the DTO is null.
     */
    fun mapFlickrLink(launchLinksId: Long, flickrLink: FlickrLinkDto?): FlickrLinkEntity?

    /**
     * Maps a list of launch core DTOs to a list of launch core entities.
     *
     * @param launchId The ID of the launch this core is associated with.
     * @param cores A list of [LaunchCoreDto] representing the cores (stages) used in the launch.
     * @return A list of [LaunchCoreEntity] for local storage.
     */
    fun mapCores(launchId: Long, cores: List<LaunchCoreDto>): List<LaunchCoreEntity>

    /**
     * Maps a launch fairings DTO to a launch fairings entity.
     *
     * @param launchId The ID of the launch this fairing is associated with.
     * @param fairings A [LaunchFairingsDto] object representing launch fairing data.
     * @return A [LaunchFairingsEntity] for local storage, or null if the DTO is null.
     */
    fun mapFairings(launchId: Long, fairings: LaunchFairingsDto?): LaunchFairingsEntity?

    /**
     * Maps a rocket DTO to a rocket entity.
     *
     * @param rocket A [RocketDto] object representing rocket details.
     * @return A [RocketEntity] for local storage, or null if the DTO is null.
     */
    fun mapRocket(rocket: RocketDto?): RocketEntity?

    /**
     * Maps a launch pad DTO to a launch pad entity.
     *
     * @param launchPad A [LaunchPadDto] object representing the launch pad details.
     * @return A [LaunchPadEntity] for local storage, or null if the DTO is null.
     */
    fun mapLaunchPad(launchPad: LaunchPadDto?): LaunchPadEntity?

}
