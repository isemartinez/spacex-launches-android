package com.spacex.launches.data.models.presentation

/**
 * Represents the launch data in the presentation layer.
 * This model is used to display launch details in the UI and contains information about the mission, rocket, and launch site.
 *
 * @property id The unique ID of the launch.
 * @property flightNumber The flight number assigned to the launch.
 * @property missionName The name of the mission associated with the launch.
 * @property rocketName The name of the rocket used in the launch.
 * @property rocketType The type or classification of the rocket.
 * @property launchSiteName The name of the launch site where the launch took place.
 * @property flightDetails Additional details about the launch (optional).
 * @property launchPadImageURL The URL of an image representing the launch pad.
 * @property launchDate The date and time of the launch in a readable format.
 */
data class Launch(
    val id: Long,
    val flightNumber: String,
    val missionName: String,
    val rocketName: String,
    val rocketType: String,
    val launchSiteName: String,
    val flightDetails: String?,
    val launchPadImageURL: String,
    val launchDate: String
)
