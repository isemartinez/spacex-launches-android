package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing the core (first stage) of a rocket launch retrieved from a remote API.
 * This object contains details about the core, including its reuse status, landing attempt, and landing success.
 *
 * @property core The unique identifier for the rocket core (optional).
 * @property flight The number of flights this core has completed (optional).
 * @property gridfins Indicates whether the core has grid fins for aerodynamic control (optional).
 * @property legs Indicates whether the core has landing legs (optional).
 * @property reused Indicates whether the core has been reused from a previous mission (optional).
 * @property landingAttempt Indicates whether a landing attempt was made for the core (optional).
 * @property landingSuccess Indicates whether the core's landing was successful (optional).
 * @property landingType The type of landing attempted (e.g., ASDS, RTLS) (optional).
 * @property landpad The unique identifier for the landing pad used (optional).
 */
data class LaunchCoreDto(
    val core: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val legs: Boolean?,
    val reused: Boolean?,
    val landingAttempt: Boolean?,
    val landingSuccess: Boolean?,
    val landingType: String?,
    val landpad: String?
)
