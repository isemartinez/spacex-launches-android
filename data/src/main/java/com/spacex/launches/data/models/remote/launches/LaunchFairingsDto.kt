package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

data class LaunchFairingsDto(
    val reused: Boolean,
    @SerializedName("recovery_attempt") val recoveryAttempt: Boolean,
    val recovered: Boolean,
    val ships: List<String>
)
