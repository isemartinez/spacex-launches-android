package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the fairings (protective shells) used during a SpaceX launch,
 * retrieved from a remote API. This object contains details about the fairings' reuse, recovery attempts,
 * and the ships involved in the recovery process.
 *
 * @property reused Indicates whether the fairings were reused from a previous mission.
 * @property recoveryAttempt Indicates whether a recovery attempt for the fairings was made after the launch.
 * @property recovered Indicates whether the fairings were successfully recovered after the launch.
 * @property ships A list of ship IDs involved in the recovery operation of the fairings.
 */
data class LaunchFairingsDto(
    val reused: Boolean,
    @SerializedName("recovery_attempt") val recoveryAttempt: Boolean,
    val recovered: Boolean,
    val ships: List<String>
)
