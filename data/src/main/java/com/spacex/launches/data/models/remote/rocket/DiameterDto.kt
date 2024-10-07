package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the diameter of a rocket component, retrieved from a remote API.
 * This object contains the diameter measured in both meters and feet.
 *
 * @property meters The diameter of the component in meters.
 * @property feet The diameter of the component in feet.
 */
data class DiameterDto(
    val meters: Double,
    val feet: Double
)
