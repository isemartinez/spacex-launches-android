package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchEntity
import com.spacex.launches.data.models.local.LaunchEntityWrapper

/**
 * Data Access Object (DAO) for handling operations related to the `launches` table.
 * This DAO provides methods to insert, retrieve, and delete launch data in the local Room database.
 * It abstracts the SQLite operations required for interacting with the launch data.
 */
@Dao
internal interface LaunchDao {

    /**
     * Inserts a launch record into the `launches` table.
     * If a launch with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launch A [LaunchEntity] object representing the launch to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced launch.
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunch(launch: LaunchEntity): Long

    /**
     * Retrieves all launches from the `launches` table.
     *
     * @return A [List] of [LaunchEntityWrapper] representing all the launches stored in the database.
     *
     * Example usage:
     * ```
     * val launches: List<LaunchEntityWrapper> = launchDao.getLaunches()
     * ```
     */
    @Query("SELECT * FROM launches")
    suspend fun getLaunches(): List<LaunchEntityWrapper>

    /**
     * Retrieves a specific launch by its remote ID (launchId) from the `launches` table.
     *
     * @param launchId The remote ID of the launch.
     * @return A [LaunchEntityWrapper] representing the launch, or null if not found.
     *
     * Example usage:
     * ```
     * val launch = launchDao.getLaunchByRemoteId("abc123")
     * ```
     */
    @Query("SELECT * FROM launches WHERE launchId = :launchId")
    suspend fun getLaunchByRemoteId(launchId: String): LaunchEntityWrapper?

    /**
     * Retrieves a specific launch by its local database ID from the `launches` table.
     *
     * @param id The local database ID of the launch.
     * @return A [LaunchEntityWrapper] representing the launch, or null if not found.
     *
     * Example usage:
     * ```
     * val launch = launchDao.getLaunchByLocalId(1L)
     * ```
     */
    @Query("SELECT * FROM launches WHERE id = :id")
    suspend fun getLaunchByLocalId(id: Long): LaunchEntityWrapper?

    /**
     * Deletes all launches from the `launches` table.
     * This will remove all entries and leave the table empty.
     *
     * Example usage:
     * ```
     * launchDao.deleteLaunches()
     * ```
     */
    @Query("DELETE FROM launches")
    suspend fun deleteLaunches()
}
