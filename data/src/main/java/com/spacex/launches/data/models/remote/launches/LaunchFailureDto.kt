package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing a failure that occurred during a SpaceX launch, retrieved from a remote API.
 * This object contains details about the failure, including the time, altitude, and reason for the failure.
 *
 * @property time The time in seconds after launch when the failure occurred.
 * @property altitude The altitude (in meters) at which the failure occurred, if available (optional).
 * @property reason A string describing the reason for the failure.
 */
data class LaunchFailureDto(
    val time: Long,
    val altitude: Double?,
    val reason: String
)
