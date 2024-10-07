package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "launch-fairings",
    foreignKeys = [ForeignKey(
        entity = LaunchEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class LaunchFairingsEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchId: Long,
    val reused: Boolean,
    val recoveryAttempt: Boolean,
    val recovered: Boolean,
    val ships: String
)