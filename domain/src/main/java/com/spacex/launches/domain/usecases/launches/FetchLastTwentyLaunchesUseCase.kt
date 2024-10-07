package com.spacex.launches.domain.usecases.launches

import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result

interface FetchLastTwentyLaunchesUseCase {
    suspend fun execute(refresh: Boolean = false): Result<List<PresentationItem>>
}