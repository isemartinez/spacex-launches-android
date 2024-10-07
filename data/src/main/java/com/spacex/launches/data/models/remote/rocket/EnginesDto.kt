package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

data class EnginesDto(
    val isp: ISPDto,
    @SerializedName("thrust_sea_level")
    val thrustSeaLevel: ThrustDto,
    @SerializedName("thrust_vacuum")
    val thrustVacuum: ThrustDto,
    val number: Int,
    val type: String,
    val version: String,
    val layout: String,
    @SerializedName("engine_loss_max")
    val engineLossMax: String,
    @SerializedName("propellant_1")
    val propellant1: String,
    @SerializedName("propellant_2")
    val propellant2: String,
    @SerializedName("thrust_to_weight")
    val thrustToWeight: Double
)
