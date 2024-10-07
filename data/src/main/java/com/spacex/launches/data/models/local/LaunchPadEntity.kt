package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launchpads")
data class LaunchPadEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchpadId: String,
    val details: String,
    val status: String,
    val launches: String,
    val timezone: String,
    val rockets: String,
    val launchSuccesses: Long,
    val launchAttempts: Long,
    val longitude: Double,
    val latitude: Double,
    val region: String,
    val locality: String,
    val fullName: String,
    val name: String,
    val imageURL: String
)
