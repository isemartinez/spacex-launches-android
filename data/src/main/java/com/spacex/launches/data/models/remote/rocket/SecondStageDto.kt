package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the second stage of a rocket, retrieved from a remote API.
 * This object contains details about the second stage's thrust, payloads, engines, and fuel capacity.
 *
 * @property thrust An instance of [ThrustDto] representing the thrust produced by the second stage.
 * @property payloads An instance of [PayLoadsDto] representing the payload configuration for the second stage.
 * @property reusable Indicates whether the second stage is reusable.
 * @property engines The number of engines on the second stage.
 * @property fuelAmountTons The amount of fuel, in tons, used by the second stage.
 * @property burnTimeSeconds The burn time of the second stage in seconds.
 */
data class SecondStageDto(
    val thrust: ThrustDto,
    val payloads: PayLoadsDto,
    val reusable: Boolean,
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double,
    @SerializedName("burn_time_sec")
    val burnTimeSeconds: Int
)
