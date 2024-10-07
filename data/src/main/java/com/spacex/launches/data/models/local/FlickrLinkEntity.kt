package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "flickr-links",
    foreignKeys = [ForeignKey(
        entity = LaunchLinksEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchLinksId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class FlickrLinkEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchLinksId: Long,
    val small: String,
    val original: String
)
