package com.spacex.launches.data.models.remote.rocket

import com.google.gson.annotations.SerializedName

data class PayLoadsDto(
    @SerializedName("composite_fairing")
    val compositeFairing: CompositeFairingDto,
    @SerializedName("option_1")
    val option1:String
)
