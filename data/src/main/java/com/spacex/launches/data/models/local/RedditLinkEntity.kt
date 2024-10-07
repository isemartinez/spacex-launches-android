package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reddit-links",
    foreignKeys = [ForeignKey(
        entity = LaunchLinksEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchLinksId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class RedditLinkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchLinksId: Long,
    val campaign: String?,
    val launch: String?,
    val media: String?,
    val recovery: String?
)
