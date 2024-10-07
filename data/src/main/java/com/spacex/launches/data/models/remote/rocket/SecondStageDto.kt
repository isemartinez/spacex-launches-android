package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

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