package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

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
