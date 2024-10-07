package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing Reddit links associated with a SpaceX launch, retrieved from a remote API.
 * This object contains URLs to various Reddit discussions related to different aspects of the launch, such as the campaign, launch, media, and recovery.
 *
 * @property campaign The URL for the Reddit campaign discussion (optional).
 * @property launch The URL for the Reddit launch discussion (optional).
 * @property media The URL for the Reddit media discussion (optional).
 * @property recovery The URL for the Reddit recovery discussion (optional).
 */
data class RedditLinkDto(
    val campaign: String?,
    val launch: String?,
    val media: String?,
    val recovery: String?
)
