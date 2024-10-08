package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Represents a patch link entity stored in the local Room database.
 * This entity contains URLs to small and large images of a patch associated with a SpaceX launch.
 * It is linked to the `LaunchLinksEntity` via a foreign key, representing the links related to the launch.
 *
 * @property id The unique ID of the patch link (autogenerated by Room).
 * @property launchLinksId The ID of the associated launch link, which acts as a foreign key referencing the `LaunchLinksEntity`.
 * @property small The URL of the small-sized patch image (optional).
 * @property large The URL of the large-sized patch image (optional).
 */
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
