package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the payloads configuration of a rocket, retrieved from a remote API.
 * This object contains details about the composite fairing and an additional payload option.
 *
 * @property compositeFairing An instance of [CompositeFairingDto] representing the composite fairing of the payload.
 * @property option1 The first payload option, typically a string describing the configuration.
 */
data class PayLoadsDto(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairingDto,
    @SerializedName("option_1")
    val option1: String
)
