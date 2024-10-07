package com.spacex.launches.data.models.presentation

data class Launch(
    val id: Long,
    val flightNumber: String,
    val missionName: String,
    val rocketName: String,
    val rocketType: String,
    val launchSiteName: String,
    val flightDetails: String?,
    val launchPadImageURL: String,
    val launchDate: String,
)
