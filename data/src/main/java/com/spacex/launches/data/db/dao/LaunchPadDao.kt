package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchPadEntity

/**
 * Data Access Object (DAO) for managing operations related to the `launchpads` table.
 * This DAO provides methods to insert, retrieve, and delete launchpad data in the local Room database.
 * The launchpad data represents SpaceX launch sites, including details like location, status, and success rates.
 */
@Dao
interface LaunchPadDao {

    /**
     * Inserts a launchpad record into the `launchpads` table.
     * If a record with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param launchPad A [LaunchPadEntity] object representing the launchpad to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced launchpad.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchPad(launchPad: LaunchPadEntity): Long

    /**
     * Retrieves a specific launchpad by its launchpad ID (launchpadId) from the `launchpads` table.
     *
     * @param id The unique launchpad ID used to identify the launchpad.
     * @return A [LaunchPadEntity] representing the launchpad, or null if not found.
     */
    @Query("SELECT * FROM launchpads WHERE launchpadId = :id")
    suspend fun getLaunchPadById(id: String): LaunchPadEntity?

    /**
     * Deletes all launchpad records from the `launchpads` table.
     * This will remove all entries and leave the table empty.
     */
    @Query("DELETE FROM launchpads")
    suspend fun deleteLaunchPads()

    /**
     * Retrieves all launchpad records from the `launchpads` table.
     *
     * @return A [List] of [LaunchPadEntity] representing all launchpads stored in the database.
     */
    @Query("SELECT * FROM launchpads")
    suspend fun getLaunchPads(): List<LaunchPadEntity>

}
