package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the first stage of a rocket, retrieved from a remote API.
 * This object contains details about the first stage, including its thrust, engine count, and fuel capacity.
 *
 * @property thrustSeaLevel An instance of [ThrustDto] representing the thrust of the first stage at sea level.
 * @property thrustVacuumDto An instance of [ThrustDto] representing the thrust of the first stage in vacuum.
 * @property reusable Indicates whether the first stage is reusable.
 * @property engines The number of engines on the first stage.
 * @property fuelAmountTons The amount of fuel in tons used by the first stage.
 * @property burnTimeSeconds The burn time of the first stage in seconds.
 */
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
