package com.spacex.launches.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Represents a wrapper around a launch links entity, containing additional related data from other link entities.
 * This data class is used to retrieve a launch's links along with its associated patch, Reddit, and Flickr links in a single query.
 *
 * @property launchLinksEntity The main launch links entity that holds the core link data.
 * @property patch The associated patch link entity, which contains information about patch images (optional).
 * @property reddit The associated Reddit link entity, which contains links to related Reddit content (optional).
 * @property flickr The associated Flickr link entity, which contains image URLs from Flickr (optional).
 */
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
