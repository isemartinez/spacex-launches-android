package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

data class ISPDto(
    @SerializedName("sea_level")
    val seaLevel: Int,
    val vacuum: Int
)
