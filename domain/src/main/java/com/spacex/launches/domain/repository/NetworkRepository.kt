package com.spacex.launches.domain.repository

interface NetworkRepository {

    suspend fun checkInternetConnection(): Boolean

}