package com.spacex.launches.domain.usecases.network

import com.spacex.launches.domain.repository.NetworkRepository

class CheckInternetConnectionUseCaseImpl(private val networkRepository: NetworkRepository) :
    CheckInternetConnectionUseCase {
    override suspend fun execute(): Boolean {
        return networkRepository.checkInternetConnection()
    }
}