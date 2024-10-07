package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launches")
internal data class LaunchEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val autoUpdate: Boolean,
    val capsules: String,
    val crew: String,
    val dateLocal: String?,
    val datePrecision: String?,
    val dateUnix: Long,
    val dateUtc: String?,
    val details: String?,
    val flightNumber: Long,
    val launchId: String?,
    val launchLibraryId: String?,
    val launchpadId: String?,
    val name: String,
    val net: Boolean,
    val payloads: String,
    val rocket: String?,
    val ships: String,
    val staticFireDateUnix: Long,
    val staticFireDateUtc: String?,
    val success: Boolean,
    val tbd: Boolean,
    val upcoming: Boolean,
    val window: Long
)

