package com.spacex.launches.data.models.remote.launchpad

/**
 * Data Transfer Object (DTO) representing images associated with a SpaceX launch pad, retrieved from a remote API.
 * This object contains a list of URLs for large-sized images of the launch pad.
 *
 * @property large A list of URLs to large-sized images of the launch pad.
 */
data class LaunchPadImage(
    val large: List<String>
)
