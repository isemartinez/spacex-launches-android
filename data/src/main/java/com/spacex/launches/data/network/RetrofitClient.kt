package com.spacex.launches.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton object responsible for creating and managing the Retrofit instance used for making network requests to the SpaceX API.
 * This object includes an [OkHttpClient] with logging and timeout settings, and a [Retrofit] instance configured with Gson for JSON conversion.
 */
internal object RetrofitClient {

    private const val BASE_URL = "https://api.spacexdata.com"

    // Logging interceptor to log HTTP request and response data for debugging purposes.
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // OkHttpClient configuration with timeout settings and the logging interceptor.
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    // Retrofit instance configured with the base URL and Gson converter for handling JSON responses.
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
