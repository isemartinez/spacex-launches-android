package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

/**
 * Data Transfer Object (DTO) representing the various links associated with a SpaceX launch,
 * retrieved from a remote API. This object contains links to media, press kits, and social media discussions
 * related to the launch.
 *
 * @property patch The [PatchLinkDto] containing URLs for patch images (optional).
 * @property reddit The [RedditLinkDto] containing links to Reddit discussions related to the launch (optional).
 * @property flickr The [FlickrLinkDto] containing URLs to Flickr images related to the launch (optional).
 * @property presskit The URL to the press kit related to the launch (optional).
 * @property webcast The URL to the webcast of the launch (optional).
 * @property youtubeId The YouTube ID for the launch video (optional).
 * @property article The URL to an article related to the launch (optional).
 * @property wikipedia The URL to the Wikipedia page for the launch (optional).
 */
data class LaunchLinksDto(
    val patch: PatchLinkDto?,
    val reddit: RedditLinkDto?,
    val flickr: FlickrLinkDto?,
    val presskit: String?,
    val webcast: String?,
    @SerializedName("youtube_id")
    val youtubeId: String?,
    val article: String?,
    val wikipedia: String?
)
