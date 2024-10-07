package com.spacex.launches.ui.main.launches.viewmodel

import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result

interface LaunchesViewModelContract {

    suspend fun fetchLastTwentyLaunches(refresh: Boolean = false): Result<List<PresentationItem>>

    suspend fun fetchLaunchById(id: Long?): Launch?

}