package com.spacex.launches.ui.main.splash

import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result

interface SplashScreenViewModelContract {
    suspend fun fetchLastTwentyLaunches(): Result<List<PresentationItem>>
}