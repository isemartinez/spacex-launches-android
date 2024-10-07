package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the composite fairing of a rocket, retrieved from a remote API.
 * This object contains details about the height and diameter of the rocket's fairing.
 *
 * @property height An instance of [HeightDto] representing the height of the fairing.
 * @property diameter An instance of [DiameterDto] representing the diameter of the fairing.
 */
data class CompositeFairingDto(
    val height: HeightDto,
    val diameter: DiameterDto
)
