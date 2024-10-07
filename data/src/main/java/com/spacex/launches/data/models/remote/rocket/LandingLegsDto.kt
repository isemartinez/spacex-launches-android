package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the landing legs of a rocket, retrieved from a remote API.
 * This object contains details about the number of landing legs and the material used.
 *
 * @property number The number of landing legs on the rocket.
 * @property material The material used for the landing legs (optional).
 */
data class LandingLegsDto(
    val number: Int,
    val material: String?
)
