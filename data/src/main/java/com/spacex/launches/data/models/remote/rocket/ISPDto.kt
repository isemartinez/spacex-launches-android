package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the specific impulse (ISP) of a rocket engine, retrieved from a remote API.
 * ISP is a measure of the efficiency of the rocket engine in terms of thrust produced per unit of propellant consumed.
 *
 * @property seaLevel The specific impulse at sea level, measured in seconds.
 * @property vacuum The specific impulse in a vacuum, measured in seconds.
 */
data class ISPDto(
    @SerializedName("sea_level")
    val seaLevel: Int,
    val vacuum: Int
)
