package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchFairingsEntity

/**
 * Data Access Object (DAO) for handling operations related to the `launch-fairings` table.
 * This DAO provides methods to insert, retrieve, and delete launch fairings data from the local Room database.
 * It abstracts the SQLite operations required for interacting with launch fairings data.
 */
@Dao
internal interface LaunchFairingsDao {

    /**
     * Inserts a launch fairings record into the `launch-fairings` table.
     * If a record with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchFairings A [LaunchFairingsEntity] object representing the launch fairings to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced launch fairings.
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchFairings(launchFairings: LaunchFairingsEntity): Long

    /**
     * Retrieves all launch fairings records from the `launch-fairings` table.
     *
     * @return A [List] of [LaunchFairingsEntity] representing all launch fairings stored in the database.
     *
     * Example usage:
     * ```
     * val fairings: List<LaunchFairingsEntity> = launchFairingsDao.getLaunchFairings()
     * ```
     */
    @Query("SELECT * FROM `launch-fairings`")
    suspend fun getLaunchFairings(): List<LaunchFairingsEntity>

    /**
     * Deletes all launch fairings records from the `launch-fairings` table.
     * This will remove all entries and leave the table empty.
     *
     * Example usage:
     * ```
     * launchFairingsDao.deleteLaunchFairings()
     * ```
     */
    @Query("DELETE FROM `launch-fairings`")
    suspend fun deleteLaunchFairings()
}
