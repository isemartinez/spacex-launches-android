package com.spacex.launches.data.models.remote.launches

data class LaunchFailureDto(
    val time: Long,
    val altitude: Double?,
    val reason: String
)
