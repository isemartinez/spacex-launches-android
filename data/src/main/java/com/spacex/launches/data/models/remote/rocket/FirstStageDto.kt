package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

data class FirstStageDto(
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustDto,
    @SerializedName("thrust_vacuum")
    val thrustVacuumDto: ThrustDto,
    val reusable: Boolean,
    val engines: Int,
    @SerializedName("fuel_amount_tons")
    val fuelAmountTons: Double,
    @SerializedName("burn_time_sec")
    val burnTimeSeconds: Int
)
