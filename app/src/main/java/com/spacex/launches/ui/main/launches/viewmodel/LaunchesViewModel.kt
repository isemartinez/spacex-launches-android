package com.spacex.launches.ui.main.launches.viewmodel

import androidx.lifecycle.ViewModel
import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result
import com.spacex.launches.domain.usecases.launches.FetchLastTwentyLaunchesUseCase
import com.spacex.launches.domain.usecases.launches.FetchLaunchByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LaunchesViewModel @Inject constructor(
    private val fetchLastTwentyLaunchesUseCase: FetchLastTwentyLaunchesUseCase,
    private val fetchLaunchByIdUseCase: FetchLaunchByIdUseCase
) :ViewModel(), LaunchesViewModelContract {

    override suspend fun fetchLastTwentyLaunches(refresh: Boolean): Result<List<PresentationItem>> {
        return fetchLastTwentyLaunchesUseCase.execute(refresh = refresh)
    }

    override suspend fun fetchLaunchById(id: Long?): Launch? {
        return id?.let { fetchLaunchByIdUseCase.execute(id) }
    }
}