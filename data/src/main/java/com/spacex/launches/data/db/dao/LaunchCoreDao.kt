package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchCoreEntity

/**
 * Data Access Object (DAO) for handling database operations related to the `launch-cores` table.
 * This DAO provides methods to insert, retrieve, and delete launch core data from the local database.
 * It uses Room to abstract the database layer for SQLite operations.
 */
@Dao
internal interface LaunchCoreDao {

    /**
     * Inserts a list of launch cores into the `launch-cores` table.
     * If a core with the same primary key already exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchCores A [List] of [LaunchCoreEntity] objects representing the launch cores to insert.
     * @return A [List] of [Long] values representing the row IDs of the inserted or replaced launch cores.
     *
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchCores(launchCores: List<LaunchCoreEntity>): List<Long>

    /**
     * Retrieves all launch cores from the `launch-cores` table.
     *
     * @return A [List] of [LaunchCoreEntity] representing all launch cores stored in the database.
     *
     * Example usage:
     * ```
     * val cores: List<LaunchCoreEntity> = launchCoreDao.getLaunchCores()
     * ```
     */
    @Query("SELECT * FROM `launch-cores`")
    suspend fun getLaunchCores(): List<LaunchCoreEntity>

    /**
     * Deletes all launch cores from the `launch-cores` table.
     * This will remove all entries in the table.
     *
     * Example usage:
     * ```
     * launchCoreDao.deleteLaunchCores()
     * ```
     */
    @Query("DELETE FROM `launch-cores`")
    suspend fun deleteLaunchCores()
}
