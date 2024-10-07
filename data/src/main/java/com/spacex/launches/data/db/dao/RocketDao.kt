package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.RocketEntity

/**
 * Data Access Object (DAO) for handling operations related to the `rockets` table.
 * This DAO provides methods to insert, retrieve, and delete rocket data in the local Room database.
 * The rocket data includes information such as rocket name, type, and other details relevant to SpaceX rockets.
 */
@Dao
internal interface RocketDao {

    /**
     * Inserts a rocket record into the `rockets` table.
     * If a rocket with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param rocket A [RocketEntity] object representing the rocket to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced rocket.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRocket(rocket: RocketEntity): Long

    /**
     * Retrieves all rocket records from the `rockets` table.
     *
     * @return A [List] of [RocketEntity] representing all rockets stored in the database.
     */
    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<RocketEntity>

    /**
     * Deletes all rocket records from the `rockets` table.
     * This will remove all entries and leave the table empty.
     */
    @Query("DELETE FROM rockets")
    suspend fun deleteRockets()

    /**
     * Retrieves a specific rocket by its rocket ID (rocketId) from the `rockets` table.
     *
     * @param rocketId The unique rocket ID used to identify the rocket.
     * @return A [RocketEntity] representing the rocket, or null if not found.
     */
    @Query("SELECT * FROM rockets WHERE rocketId = :rocketId")
    suspend fun getRocketById(rocketId: String): RocketEntity?
}
