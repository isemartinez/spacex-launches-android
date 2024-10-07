package com.spacex.launches.domain.usecases.launches

import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.repository.SpaceXRepository

class FetchLaunchByIdUseCaseImpl(private val spaceXRepository: SpaceXRepository) :
    FetchLaunchByIdUseCase {
    override suspend fun execute(id: Long): Launch? {
        return spaceXRepository.fetchLaunchById(id = id)
    }
}