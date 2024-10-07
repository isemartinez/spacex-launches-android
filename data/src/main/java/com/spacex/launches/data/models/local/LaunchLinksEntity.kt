package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "launch-links",
    foreignKeys = [ForeignKey(
        entity = LaunchEntity::class,
        parentColumns = ["id"],
        childColumns = ["launchId"],
        onDelete = ForeignKey.CASCADE
    )]
)
internal data class LaunchLinksEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val launchId:Long,
    val presskitUrl: String?,
    val webcastUrl: String?,
    val youtubeId: String?,
    val articleUrl: String?,
    val wikipediaUrl: String?
)
