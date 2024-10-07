package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the height of a rocket component, retrieved from a remote API.
 * This object contains the height measured in both meters and feet.
 *
 * @property meters The height of the component in meters.
 * @property feet The height of the component in feet.
 */
data class HeightDto(
    val meters: Double,
    val feet: Double
)
