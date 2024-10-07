package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the engines of a rocket, retrieved from a remote API.
 * This object contains details about the engines, including their thrust, type, version, and propellants.
 *
 * @property isp An instance of [ISPDto] representing the specific impulse of the engines.
 * @property thrustSeaLevel An instance of [ThrustDto] representing the thrust at sea level.
 * @property thrustVacuum An instance of [ThrustDto] representing the thrust in vacuum.
 * @property number The number of engines.
 * @property type The type of engines (e.g., Merlin, Raptor).
 * @property version The version of the engine.
 * @property layout The layout configuration of the engines (e.g., octaweb).
 * @property engineLossMax The maximum number of engines that can be lost while still achieving mission success.
 * @property propellant1 The first propellant used by the engines.
 * @property propellant2 The second propellant used by the engines.
 * @property thrustToWeight The thrust-to-weight ratio of the engines.
 */
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
