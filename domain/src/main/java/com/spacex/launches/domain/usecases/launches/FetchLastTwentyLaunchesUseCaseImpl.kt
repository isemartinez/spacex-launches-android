package com.spacex.launches.domain.usecases.launches

import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.models.remote.launches.LaunchOptions
import com.spacex.launches.data.models.remote.launches.LaunchQueryBody
import com.spacex.launches.data.repository.SpaceXRepository
import com.spacex.launches.data.states.Result
import com.spacex.launches.domain.usecases.network.CheckInternetConnectionUseCase

class FetchLastTwentyLaunchesUseCaseImpl(
    private val spaceXRepository: SpaceXRepository,
    private val checkInternetConnectionUseCase: CheckInternetConnectionUseCase
) : FetchLastTwentyLaunchesUseCase {

    override suspend fun execute(refresh: Boolean): Result<List<PresentationItem>> {

        val isConnected = checkInternetConnectionUseCase.execute()
        val launchesFromDBResult = spaceXRepository.fetchLaunchesFromDB()

        val launchesFromDB = when (launchesFromDBResult) {
            is Result.Success -> launchesFromDBResult.data
            is Result.Error -> return Result.Error(launchesFromDBResult.exception)
        }

        val response = mutableListOf<PresentationItem>()

        if (!isConnected) {

            if (launchesFromDB.isEmpty()) {
                return Result.Error(IllegalStateException("No internet connection and no data in database"))
            } else {
                response.add(PresentationItem.Header(title = "LAUNCHES", backgroundURL = spaceXRepository.fetchLaunchesURL()))
                launchesFromDB.forEach { response.add(PresentationItem.Launch(it)) }
                return Result.Success(response)
            }
        } else {
            if (launchesFromDB.isEmpty() || refresh) {
                val requestBody = LaunchQueryBody(options = LaunchOptions())
                when (val launches = spaceXRepository.fetchLaunchesByQueryFromAPI(requestBody)) {
                    is Result.Success -> {
                        response.add(PresentationItem.Header(title = "LAUNCHES", backgroundURL = spaceXRepository.fetchLaunchesURL()))
                        launches.data.forEach { response.add(PresentationItem.Launch(it)) }
                        return Result.Success(response)
                    }
                    is Result.Error -> {
                        return Result.Error(launches.exception)
                    }
                }
            } else {
                response.add(PresentationItem.Header(title = "LAUNCHES", backgroundURL = spaceXRepository.fetchLaunchesURL()))
                launchesFromDB.forEach { response.add(PresentationItem.Launch(it)) }
                return Result.Success(response)
            }
        }
    }
}
