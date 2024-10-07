package com.spacex.launches.data.models.remote.rocket

/**
 * Data Transfer Object (DTO) representing the thrust produced by a rocket engine, retrieved from a remote API.
 * This object contains the thrust values in both kilonewtons (kN) and pounds-force (lbf).
 *
 * @property kN The thrust produced by the engine, measured in kilonewtons (kN).
 * @property lbf The thrust produced by the engine, measured in pounds-force (lbf).
 */
data class ThrustDto(
    val kN: Int,
    val lbf: Int
)
