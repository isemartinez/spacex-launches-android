package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "patch-links",
    foreignKeys = [ForeignKey(
        entity = LaunchLinksEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchLinksId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class PatchLinkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchLinksId: Long,
    val small: String?,
    val large: String?
)
