package com.spacex.launches.data.models.remote.launches

data class LaunchQueryResponse(
    val docs: List<LaunchDto>,
    val totalDocs: Long,
    val offset: Long,
    val limit: Long,
    val totalPages: Long,
    val page: Long,
    val pagingCounter: Long,
    val hasPrevPage: Boolean,
    val hasNextPage: Boolean,
    val prevPage: Long?,
    val nextPage: Long?
)
