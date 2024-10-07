package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.RedditLinkEntity

/**
 * Data Access Object (DAO) for handling operations related to the `reddit-links` table.
 * This DAO provides methods to insert, retrieve, and delete Reddit link data from the local Room database.
 * The Reddit links represent different links (campaign, launch, media, recovery) related to a specific launch.
 */
@Dao
internal interface RedditLinkDao {

    /**
     * Inserts a Reddit link record into the `reddit-links` table.
     * If a link with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param redditLink A [RedditLinkEntity] object representing the Reddit link to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced Reddit link.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRedditLink(redditLink: RedditLinkEntity): Long

    /**
     * Retrieves all Reddit link records from the `reddit-links` table.
     *
     * @return A [List] of [RedditLinkEntity] representing all Reddit links stored in the database.
     */
    @Query("SELECT * FROM `reddit-links`")
    suspend fun getRedditLinks(): List<RedditLinkEntity>

    /**
     * Deletes all Reddit link records from the `reddit-links` table.
     * This will remove all entries and leave the table empty.
     */
    @Query("DELETE FROM `reddit-links`")
    suspend fun deleteRedditLinks()

}
