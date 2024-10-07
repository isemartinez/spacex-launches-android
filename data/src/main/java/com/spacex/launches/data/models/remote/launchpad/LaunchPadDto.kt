package com.spacex.launches.data.models.remote.launchpad

import com.google.gson.annotations.SerializedName

data class LaunchPadDto(
    val id: String,
    val details: String,
    val status: String,
    val launches: List<String>,
    val timezone: String,
    val rockets: List<String>,
    @SerializedName("launch_successes")
    val launchSuccesses: Long,
    @SerializedName("launch_attempts")
    val launchAttempts: Long,
    val longitude: Double,
    val latitude: Double,
    val region: String,
    val locality: String,
    @SerializedName("full_name")
    val fullName: String,
    val name: String,
    val images: LaunchPadImage
)
