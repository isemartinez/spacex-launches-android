package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchFailureEntity

/**
 * Data Access Object (DAO) for handling operations related to the `launch-failures` table.
 * This DAO provides methods to insert, retrieve, and delete launch failure data from the local Room database.
 * It abstracts the database interactions for launch failures.
 */
@Dao
internal interface LaunchFailureDao {

    /**
     * Inserts a list of launch failure records into the `launch-failures` table.
     * If a failure record with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchFailures A [List] of [LaunchFailureEntity] representing the launch failures to be inserted.
     * @return A [List] of [Long] values representing the row IDs of the inserted or replaced launch failures.
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchFailures(launchFailures: List<LaunchFailureEntity>): List<Long>

    /**
     * Retrieves all launch failure records from the `launch-failures` table.
     *
     * @return A [List] of [LaunchFailureEntity] representing all launch failures stored in the database.
     *
     * Example usage:
     * ```
     * val failures: List<LaunchFailureEntity> = launchFailureDao.getLaunchFailures()
     * ```
     */
    @Query("SELECT * FROM `launch-failures`")
    suspend fun getLaunchFailures(): List<LaunchFailureEntity>

    /**
     * Deletes all launch failure records from the `launch-failures` table.
     * This will remove all entries and leave the table empty.
     *
     * Example usage:
     * ```
     * launchFailureDao.deleteLaunchFailures()
     * ```
     */
    @Query("DELETE FROM `launch-failures`")
    suspend fun deleteLaunchFailures()
}
