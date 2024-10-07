package com.spacex.launches.data.repository

import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.remote.launches.LaunchQueryBody
import com.spacex.launches.data.states.Result

interface SpaceXRepository {

    suspend fun fetchLaunchesURL(): String

    suspend fun fetchLaunchesByQueryFromAPI(query: LaunchQueryBody): Result<List<Launch>>

    suspend fun fetchLaunchesFromDB(): Result<List<Launch>>

    suspend fun fetchLaunchById(id: Long): Launch?

}
