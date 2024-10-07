package com.spacex.launches.domain.usecases.network

interface CheckInternetConnectionUseCase {
    suspend fun execute(): Boolean
}