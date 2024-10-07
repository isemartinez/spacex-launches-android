package com.spacex.launches.data.models.remote.launches

data class LaunchOptions(
    val limit: Long = 20,
    val sort: Map<String, String> = mapOf("flight_number" to "asc")
)
