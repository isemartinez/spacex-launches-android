package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing the Flickr links retrieved from a remote API.
 * This object contains lists of URLs for images hosted on Flickr, categorized by size (small and original).
 *
 * @property small A list of URLs for small-sized images from Flickr.
 * @property original A list of URLs for original-sized images from Flickr.
 */
data class FlickrLinkDto(
    val small: List<String>,
    val original: List<String>
)
