package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing the body of a query to retrieve SpaceX launches from a remote API.
 * This object wraps the options used to control the query, such as the limit and sorting preferences.
 *
 * @property options An instance of [LaunchOptions] that specifies the parameters for limiting and sorting the query results.
 */
data class LaunchQueryBody(
    val options: LaunchOptions
)
