package com.spacex.launches.data.models.remote.rocket

data class PayloadWeightDto(
    val id: String,
    val name: String,
    val kg: Int,
    val lb: Int
)
