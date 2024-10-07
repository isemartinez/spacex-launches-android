package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing the patch links associated with a SpaceX launch, retrieved from a remote API.
 * This object contains URLs for both small and large images of the mission patch.
 *
 * @property small The URL for the small-sized patch image (optional).
 * @property large The URL for the large-sized patch image (optional).
 */
data class PatchLinkDto(
    val small: String?,
    val large: String?
)
