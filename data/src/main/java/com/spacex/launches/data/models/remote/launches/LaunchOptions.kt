package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing options for querying SpaceX launches from a remote API.
 * This object contains parameters for limiting the number of launches returned and sorting the results.
 *
 * @property limit The maximum number of launches to return in the query. Defaults to 20.
 * @property sort A map specifying the field to sort the launches by and the sort order.
 *                By default, launches are sorted by `flight_number` in ascending order.
 */
data class LaunchOptions(
    val limit: Long = 20,
    val sort: Map<String, String> = mapOf("flight_number" to "asc")
)
