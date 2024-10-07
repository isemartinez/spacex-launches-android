package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchLinksEntity
import com.spacex.launches.data.models.local.LaunchLinksWrapper

/**
 * Data Access Object (DAO) for handling operations related to the `launch-links` table.
 * This DAO provides methods to insert, retrieve, and delete launch links data from the local Room database.
 * It allows batch inserts and handles conflicts by replacing existing records with new ones.
 */
@Dao
internal interface LaunchLinksDao {

    /**
     * Inserts a single launch link record into the `launch-links` table.
     * If a link with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchLink A [LaunchLinksEntity] object representing the launch link to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced launch link.
     *
     * Example usage:
     * ```
     * val launchLink = LaunchLinksEntity(id = 1L, article = "https://example.com/article", video = "https://example.com/video")
     * val rowId = launchLinksDao.insertLaunchLinks(launchLink)
     * ```
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchLinks(launchLink: LaunchLinksEntity): Long

    /**
     * Inserts multiple launch link records into the `launch-links` table.
     * If any links with the same primary keys exist, they will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchLinks A [List] of [LaunchLinksEntity] representing the launch links to be inserted.
     * @return A [List] of [Long] values representing the row IDs of the inserted or replaced launch links.
     *
     * Example usage:
     * ```
     * val launchLinks = listOf(
     *     LaunchLinksEntity(id = 1L, article = "https://example.com/article1", video = "https://example.com/video1"),
     *     LaunchLinksEntity(id = 2L, article = "https://example.com/article2", video = "https://example.com/video2")
     * )
     * val rowIds = launchLinksDao.insertLaunchLinks(launchLinks)
     * ```
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchLinks(launchLinks: List<LaunchLinksEntity>): List<Long>

    /**
     * Retrieves all launch link records from the `launch-links` table.
     *
     * @return A [List] of [LaunchLinksWrapper] representing all launch links stored in the database.
     *
     * Example usage:
     * ```
     * val links: List<LaunchLinksWrapper> = launchLinksDao.getLaunchLinks()
     * ```
     */
    @Query("SELECT * FROM `launch-links`")
    suspend fun getLaunchLinks(): List<LaunchLinksWrapper>

    /**
     * Deletes all launch link records from the `launch-links` table.
     * This will remove all entries and leave the table empty.
     *
     * Example usage:
     * ```
     * launchLinksDao.deleteLaunchLinks()
     * ```
     */
    @Query("DELETE FROM `launch-links`")
    suspend fun deleteLaunchLinks()

}
