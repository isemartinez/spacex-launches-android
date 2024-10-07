package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "launch-cores",
    foreignKeys = [ForeignKey(
        entity = LaunchEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class LaunchCoreEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchId: Long,
    val core: String?,
    val flight: Int?,
    val gridfins: Boolean?,
    val legs: Boolean?,
    val reused: Boolean?,
    val landingAttempt: Boolean?,
    val landingSuccess: Boolean?,
    val landingType: String?,
    val landpad: String?
)
