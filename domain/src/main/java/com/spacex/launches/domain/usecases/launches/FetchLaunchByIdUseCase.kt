package com.spacex.launches.domain.usecases.launches

import com.spacex.launches.data.models.presentation.Launch

interface FetchLaunchByIdUseCase {
    suspend fun execute(id: Long): Launch?
}