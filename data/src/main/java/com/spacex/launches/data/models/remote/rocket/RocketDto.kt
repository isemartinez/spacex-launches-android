package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

data class RocketDto(
    val height: HeightDto,
    val diameter: DiameterDto,
    val mass: MassDto,
    @SerializedName("first_stage") val firstStage: FirstStageDto,
    @SerializedName("second_stage") val secondStage: SecondStageDto,
    val engines: EnginesDto,
    @SerializedName("landing_legs") val landingLegs: LandingLegsDto,
    val payloadWeights: List<PayloadWeightDto>,
    val flickrImages: List<String>,
    val name: String,
    val type: String,
    val active: Boolean,
    val stages: Int,
    val boosters: Int,
    @SerializedName("cost_per_launch") val costPerLaunch: Int,
    @SerializedName("success_rate_pct") val successRatePct: Int,
    val firstFlight: String,
    val country: String,
    val company: String,
    val wikipedia: String,
    val description: String,
    val id: String
)
