package com.spacex.launches.data.repository.network

/**
 * Interface for the network repository responsible for checking the internet connection.
 * This repository defines a method to verify whether there is an active internet connection.
 */
interface NetworkRepository {

    /**
     * Checks whether an internet connection is available.
     *
     * @return [Boolean] indicating the availability of an internet connection.
     */
    suspend fun checkInternetConnection(): Boolean

}
