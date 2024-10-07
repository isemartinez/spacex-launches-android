package com.spacex.launches.data.api

import com.spacex.launches.data.models.remote.launches.LaunchDto
import com.spacex.launches.data.models.remote.launches.LaunchQueryBody
import com.spacex.launches.data.models.remote.launches.LaunchQueryResponse
import com.spacex.launches.data.models.remote.launchpad.LaunchPadDto
import com.spacex.launches.data.models.remote.rocket.RocketDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface SpaceXApiService {

    @POST("v4/launches/query")
    suspend fun getLaunchesByQuery(@Body query: LaunchQueryBody): LaunchQueryResponse

    @GET("v4/launches")
    suspend fun getLaunches(): List<LaunchDto>

    @GET("v4/launches")
    suspend fun getLaunchById(@Path("id") id: String): LaunchDto

    @GET("v4/rockets")
    suspend fun getRockets(): List<RocketDto>

    @GET("v4/rockets/{id}")
    suspend fun getRocketById(@Path("id") id: String): RocketDto

    @GET("v4/launchpads")
    suspend fun getLaunchPads(): List<LaunchPadDto>

    @GET("v4/launchpads/{id}")
    suspend fun getLaunchPadById(@Path("id") id: String): LaunchPadDto

}