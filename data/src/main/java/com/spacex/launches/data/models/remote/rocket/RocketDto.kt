package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing detailed information about a SpaceX rocket, retrieved from a remote API.
 * This object contains information about the rocket's dimensions, stages, engines, payload weights, and other relevant details.
 *
 * @property height An instance of [HeightDto] representing the height of the rocket.
 * @property diameter An instance of [DiameterDto] representing the diameter of the rocket.
 * @property mass An instance of [MassDto] representing the mass of the rocket.
 * @property firstStage An instance of [FirstStageDto] representing details about the first stage of the rocket.
 * @property secondStage An instance of [SecondStageDto] representing details about the second stage of the rocket.
 * @property engines An instance of [EnginesDto] representing details about the rocket's engines.
 * @property landingLegs An instance of [LandingLegsDto] representing details about the rocket's landing legs.
 * @property payloadWeights A list of [PayloadWeightDto] objects representing the payload weights the rocket can carry.
 * @property flickrImages A list of URLs representing images of the rocket on Flickr.
 * @property name The name of the rocket.
 * @property type The type or classification of the rocket.
 * @property active Indicates whether the rocket is currently active.
 * @property stages The number of stages in the rocket.
 * @property boosters The number of boosters on the rocket.
 * @property costPerLaunch The cost of launching the rocket, in USD.
 * @property successRatePct The success rate of the rocket, as a percentage.
 * @property firstFlight The date of the rocket's first flight.
 * @property country The country where the rocket was built and launched.
 * @property company The company that built and operates the rocket (e.g., SpaceX).
 * @property wikipedia The URL to the Wikipedia page for the rocket.
 * @property description A detailed description of the rocket's capabilities and history.
 * @property id The unique identifier for the rocket.
 */
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
