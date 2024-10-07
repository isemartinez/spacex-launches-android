package com.spacex.launches.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

internal data class LaunchLinksWrapper(
    @Embedded
    val launchLinksEntity: LaunchLinksEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "launchLinksId"
    )
    val patch: PatchLinkEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "launchLinksId"
    )
    val reddit: RedditLinkEntity?,
    @Relation(
        parentColumn = "id",
        entityColumn = "launchLinksId"
    )
    val flickr: FlickrLinkEntity?
)
