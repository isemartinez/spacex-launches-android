package com.spacex.launches.data.models.remote.launchpad

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing a SpaceX launch pad, retrieved from a remote API.
 * This object contains detailed information about a launch pad, including its status, location, launches, and supported rockets.
 *
 * @property id The unique identifier for the launch pad.
 * @property details A string describing details about the launch pad.
 * @property status The current status of the launch pad (e.g., active, inactive).
 * @property launches A list of launch IDs associated with this launch pad.
 * @property timezone The timezone where the launch pad is located.
 * @property rockets A list of rocket IDs that can launch from this pad.
 * @property launchSuccesses The total number of successful launches from this pad.
 * @property launchAttempts The total number of launch attempts from this pad.
 * @property longitude The geographic longitude of the launch pad.
 * @property latitude The geographic latitude of the launch pad.
 * @property region The region (e.g., state or province) where the launch pad is located.
 * @property locality The locality (e.g., city) where the launch pad is located.
 * @property fullName The full name of the launch pad.
 * @property name The short name of the launch pad.
 * @property images An instance of [LaunchPadImage] containing image URLs of the launch pad.
 */
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
