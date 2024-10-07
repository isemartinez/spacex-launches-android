package com.spacex.launches.data.models.remote.launches

import com.google.gson.annotations.SerializedName

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
