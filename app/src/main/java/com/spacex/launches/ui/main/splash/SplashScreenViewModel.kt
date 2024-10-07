package com.spacex.launches.ui.main.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result
import com.spacex.launches.domain.usecases.launches.FetchLastTwentyLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(private val fetchLastTwentyLaunchesUseCase: FetchLastTwentyLaunchesUseCase) :
    ViewModel(), SplashScreenViewModelContract {
    var isDataLoaded = mutableStateOf(false)
        private set

    override suspend fun fetchLastTwentyLaunches(): Result<List<PresentationItem>> {
        val result = fetchLastTwentyLaunchesUseCase.execute()
        isDataLoaded.value = true
        return result
    }

}