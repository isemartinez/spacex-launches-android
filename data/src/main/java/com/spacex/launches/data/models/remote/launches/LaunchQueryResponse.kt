package com.spacex.launches.data.models.remote.launches

/**
 * Data Transfer Object (DTO) representing the response from a SpaceX launch query retrieved from a remote API.
 * This object contains pagination details along with the list of launches retrieved.
 *
 * @property docs A list of [LaunchDto] objects representing the launches retrieved by the query.
 * @property totalDocs The total number of documents (launches) available.
 * @property offset The offset used in the query (how many records were skipped).
 * @property limit The maximum number of launches returned in this query.
 * @property totalPages The total number of pages available.
 * @property page The current page number of the query result.
 * @property pagingCounter The counter for pagination, typically used to calculate record numbers.
 * @property hasPrevPage Indicates if there is a previous page available.
 * @property hasNextPage Indicates if there is a next page available.
 * @property prevPage The previous page number, if available (nullable).
 * @property nextPage The next page number, if available (nullable).
 */
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
