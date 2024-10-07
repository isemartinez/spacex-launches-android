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

/**
 * SpaceXApiService
 *
 * Define the interface for making API calls to the SpaceX REST endpoints
 * using Retrofit. This service handles operations such as fetching launches,
 * rockets, and launchpads from SpaceX's backend.
 */
internal interface SpaceXApiService {

    /**
     * Fetch a paginated list of launches from SpaceX based on query parameters.
     *
     * @param query [LaunchQueryBody] The query body containing filters, sort order, and pagination options.
     * @return [LaunchQueryResponse] A paginated response with the list of launches that match the query.
     *
     * Example: POST /v4/launches/query
     */
    @POST("v4/launches/query")
    suspend fun getLaunchesByQuery(@Body query: LaunchQueryBody): LaunchQueryResponse

    /**
     * Fetch all SpaceX launches.
     *
     * @return [List] A list of [LaunchDto] objects, each representing a SpaceX launch with its details.
     *
     * Example: GET /v4/launches
     */
    @GET("v4/launches")
    suspend fun getLaunches(): List<LaunchDto>

    /**
     * Fetch details of a specific launch by its ID.
     *
     * @param id [String] The unique ID of the launch.
     * @return [LaunchDto] The detailed information about the launch.
     *
     * Example: GET /v4/launches/{id}
     */
    @GET("v4/launches/{id}")
    suspend fun getLaunchById(@Path("id") id: String): LaunchDto

    /**
     * Fetch all SpaceX rockets.
     *
     * @return [List] A list of [RocketDto] objects, each representing a SpaceX rocket with its details.
     *
     * Example: GET /v4/rockets
     */
    @GET("v4/rockets")
    suspend fun getRockets(): List<RocketDto>

    /**
     * Fetch details of a specific rocket by its ID.
     *
     * @param id [String] The unique ID of the rocket.
     * @return [RocketDto] The detailed information about the rocket.
     *
     * Example: GET /v4/rockets/{id}
     */
    @GET("v4/rockets/{id}")
    suspend fun getRocketById(@Path("id") id: String): RocketDto

    /**
     * Fetch all SpaceX launchpads.
     *
     * @return [List] A list of [LaunchPadDto] objects, each representing a SpaceX launchpad with its details.
     *
     * Example: GET /v4/launchpads
     */
    @GET("v4/launchpads")
    suspend fun getLaunchPads(): List<LaunchPadDto>

    /**
     * Fetch details of a specific launchpad by its ID.
     *
     * @param id [String] The unique ID of the launchpad.
     * @return [LaunchPadDto] The detailed information about the launchpad.
     *
     * Example: GET /v4/launchpads/{id}
     */
    @GET("v4/launchpads/{id}")
    suspend fun getLaunchPadById(@Path("id") id: String): LaunchPadDto
}
