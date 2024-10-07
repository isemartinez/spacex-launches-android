package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "launch-failures",
    foreignKeys = [ForeignKey(
        entity = LaunchEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class LaunchFailureEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchId: Long,
    val time: Long,
    val altitude: Double?,
    val reason: String
)