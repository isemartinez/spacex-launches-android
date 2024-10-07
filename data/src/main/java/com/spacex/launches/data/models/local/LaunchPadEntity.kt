package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a launch pad entity stored in the local Room database.
 * This entity contains detailed information about a SpaceX launch pad, including its status, location, and the rockets it supports.
 *
 * @property id The unique ID of the launch pad (autogenerated by Room).
 * @property launchpadId The unique identifier for the launch pad.
 * @property details A string describing details about the launch pad.
 * @property status The current status of the launch pad (e.g., active, inactive).
 * @property launches A string listing the launches that have occurred at the pad.
 * @property timezone The timezone in which the launch pad is located.
 * @property rockets A string listing the rockets that are supported by this launch pad.
 * @property launchSuccesses The total number of successful launches from this pad.
 * @property launchAttempts The total number of launch attempts from this pad.
 * @property longitude The geographic longitude of the launch pad.
 * @property latitude The geographic latitude of the launch pad.
 * @property region The region where the launch pad is located (e.g., a state or province).
 * @property locality The locality or city where the launch pad is located.
 * @property fullName The full name of the launch pad.
 * @property name The short name of the launch pad.
 * @property imageURL The URL of an image representing the launch pad.
 */
@Entity(tableName = "launchpads")
data class LaunchPadEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchpadId: String,
    val details: String,
    val status: String,
    val launches: String,
    val timezone: String,
    val rockets: String,
    val launchSuccesses: Long,
    val launchAttempts: Long,
    val longitude: Double,
    val latitude: Double,
    val region: String,
    val locality: String,
    val fullName: String,
    val name: String,
    val imageURL: String
)
