package com.spacex.launches.data.repository

import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.remote.launches.LaunchQueryBody
import com.spacex.launches.data.states.Result

/**
 * Interface for the SpaceX repository, responsible for handling data operations related to SpaceX launches.
 * This repository interacts with both the remote API and the local database to fetch launch data.
 */
interface SpaceXRepository {

    /**
     * Fetches the URL used to retrieve launches.
     *
     * @return [String] containing the URL for fetching launches.
     */
    suspend fun fetchLaunchesURL(): String

    /**
     * Fetches launches from the SpaceX API based on a query.
     *
     * @param query An instance of [LaunchQueryBody] containing the query parameters for fetching launches.
     * @return [Result] containing a list of [Launch] objects or an error state.
     */
    suspend fun fetchLaunchesByQueryFromAPI(query: LaunchQueryBody): Result<List<Launch>>

    /**
     * Fetches launches from the local database.
     *
     * @return [Result] containing a list of [Launch] objects or an error state.
     */
    suspend fun fetchLaunchesFromDB(): Result<List<Launch>>

    /**
     * Fetches a specific launch by its ID.
     *
     * @param id The ID of the launch to be fetched.
     * @return [Launch] object if found, or null if not.
     */
    suspend fun fetchLaunchById(id: Long): Launch?

}
