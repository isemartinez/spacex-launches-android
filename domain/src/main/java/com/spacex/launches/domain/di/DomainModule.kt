package com.spacex.launches.domain.di

import com.spacex.launches.data.repository.SpaceXRepository
import com.spacex.launches.data.repository.network.NetworkRepository
import com.spacex.launches.domain.usecases.launches.FetchLastTwentyLaunchesUseCase
import com.spacex.launches.domain.usecases.launches.FetchLastTwentyLaunchesUseCaseImpl
import com.spacex.launches.domain.usecases.launches.FetchLaunchByIdUseCase
import com.spacex.launches.domain.usecases.launches.FetchLaunchByIdUseCaseImpl
import com.spacex.launches.domain.usecases.network.CheckInternetConnectionUseCase
import com.spacex.launches.domain.usecases.network.CheckInternetConnectionUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun providesCheckInternetConnectionUseCase(networkRepository: NetworkRepository): CheckInternetConnectionUseCase {
        return CheckInternetConnectionUseCaseImpl(networkRepository)
    }

    @Provides
    @Singleton
    fun providesGetLaunchesUseCase(
        spaceXRepository: SpaceXRepository,
        checkInternetConnectionUseCase: CheckInternetConnectionUseCase
    ): FetchLastTwentyLaunchesUseCase {
        return FetchLastTwentyLaunchesUseCaseImpl(spaceXRepository, checkInternetConnectionUseCase)
    }

    @Provides
    @Singleton
    fun providesGetLaunchByIdUseCase(
        spaceXRepository: SpaceXRepository
    ): FetchLaunchByIdUseCase {
        return FetchLaunchByIdUseCaseImpl(spaceXRepository)
    }

}