package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the mass of a rocket component, retrieved from a remote API.
 * This object contains the mass of the component in both kilograms and pounds.
 *
 * @property kg The mass of the component in kilograms.
 * @property lb The mass of the component in pounds.
 */
data class MassDto(
    val kg: Double,
    val lb: Double
)
