package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.FlickrLinkEntity

/**
 * Data Access Object (DAO) for managing operations related to the `flickr-links` table.
 * This DAO provides methods to insert, retrieve, and delete Flickr links from the local database.
 * It interacts with the Room persistence library to handle SQLite operations safely.
 */
@Dao
internal interface FlickrLinkDao {

    /**
     * Inserts a Flickr link into the `flickr-links` table.
     * If a link with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param flickrLink The [FlickrLinkEntity] object representing the link to be inserted.
     * @return The row ID of the newly inserted link, as a [Long].
     *
     * Example usage:
     * ```
     * val flickrLink = FlickrLinkEntity(id = "1", url = "https://example.com")
     * val rowId = flickrLinkDao.insertFlickrLink(flickrLink)
     * ```
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlickrLink(flickrLink: FlickrLinkEntity): Long

    /**
     * Retrieves all Flickr links from the `flickr-links` table.
     *
     * @return A [List] of [FlickrLinkEntity] representing all Flickr links stored in the database.
     *
     * Example usage:
     * ```
     * val flickrLinks: List<FlickrLinkEntity> = flickrLinkDao.getFlickrLinks()
     * ```
     */
    @Query("SELECT * FROM `flickr-links`")
    suspend fun getFlickrLinks(): List<FlickrLinkEntity>

    /**
     * Deletes all Flickr links from the `flickr-links` table.
     * This will remove all entries in the table, leaving it empty.
     *
     * Example usage:
     * ```
     * flickrLinkDao.deleteFlickrLinks()
     * ```
     */
    @Query("DELETE FROM `flickr-links`")
    suspend fun deleteFlickrLinks()
}
