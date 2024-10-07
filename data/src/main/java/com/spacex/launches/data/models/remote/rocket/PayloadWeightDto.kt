package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the payload weight information of a rocket, retrieved from a remote API.
 * This object contains the payload weight in both kilograms and pounds, along with its ID and name.
 *
 * @property id The unique identifier for the payload weight.
 * @property name The name of the payload weight configuration.
 * @property kg The payload weight in kilograms.
 * @property lb The payload weight in pounds.
 */
data class PayloadWeightDto(
    val id: String,
    val name: String,
    val kg: Int,
    val lb: Int
)
