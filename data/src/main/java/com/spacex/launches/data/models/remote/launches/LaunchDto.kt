package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing a SpaceX launch retrieved from a remote API.
 * This object contains detailed information about a launch, including the date, rocket, crew, and links to media.
 *
 * @property autoUpdate Indicates whether the launch details are automatically updated.
 * @property capsules A list of capsule IDs associated with the launch.
 * @property cores A list of [LaunchCoreDto] objects representing the cores used in the launch.
 * @property crew A list of crew member IDs involved in the launch.
 * @property dateLocal The local date and time of the launch (optional).
 * @property datePrecision The precision level of the launch date (e.g., year, month, day) (optional).
 * @property dateUnix The UNIX timestamp of the launch date.
 * @property dateUtc The UTC date and time of the launch (optional).
 * @property details Additional details about the launch (optional).
 * @property failures A list of [LaunchFailureDto] objects representing failures that occurred during the launch.
 * @property fairings The [LaunchFairingsDto] object containing fairing-related information (optional).
 * @property flightNumber The flight number of the launch.
 * @property id The unique identifier for the launch (optional).
 * @property launchLibraryId The ID of the launch in the Launch Library (optional).
 * @property launchpad The ID of the launchpad used for the launch (optional).
 * @property links The [LaunchLinksDto] object containing links to media related to the launch (optional).
 * @property name The name of the launch.
 * @property net Indicates whether the launch was subject to a network-enabled update.
 * @property payloads A list of payload IDs associated with the launch.
 * @property rocket The ID of the rocket used for the launch (optional).
 * @property ships A list of ship IDs involved in the launch.
 * @property staticFireDateUnix The UNIX timestamp of the static fire test date.
 * @property staticFireDateUtc The UTC date and time of the static fire test (optional).
 * @property success Indicates whether the launch was successful.
 * @property tbd Indicates whether the launch date is "to be determined."
 * @property upcoming Indicates whether the launch is upcoming.
 * @property window The launch window duration in seconds.
 */
data class LaunchDto(
    @SerializedName("auto_update")
    val autoUpdate: Boolean,
    val capsules: List<String>,
    val cores: List<LaunchCoreDto>,
    val crew: List<String>,
    @SerializedName("date_local")
    val dateLocal: String?,
    @SerializedName("date_precision")
    val datePrecision: String?,
    @SerializedName("date_unix")
    val dateUnix: Long,
    @SerializedName("date_utc")
    val dateUtc: String?,
    val details: String?,
    val failures: List<LaunchFailureDto>,
    val fairings: LaunchFairingsDto?,
    @SerializedName("flight_number")
    val flightNumber: Long,
    val id: String?,
    @SerializedName("launch_library_id")
    val launchLibraryId: String?,
    val launchpad: String?,
    val links: LaunchLinksDto?,
    val name: String,
    val net: Boolean,
    val payloads: List<String>,
    val rocket: String?,
    val ships: List<String>,
    @SerializedName("static_fire_date_unix")
    val staticFireDateUnix: Long,
    @SerializedName("static_fire_date_utc")
    val staticFireDateUtc: String?,
    val success: Boolean,
    val tbd: Boolean,
    val upcoming: Boolean,
    val window: Long
)
