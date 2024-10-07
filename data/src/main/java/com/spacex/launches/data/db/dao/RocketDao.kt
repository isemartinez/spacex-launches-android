package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.RocketEntity

@Dao
internal interface RocketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRocket(rocket: RocketEntity):Long

    @Query("SELECT * FROM rockets")
    suspend fun getRockets(): List<RocketEntity>

    @Query("DELETE FROM rockets")
    suspend fun deleteRockets()

    @Query("SELECT * FROM rockets WHERE rocketId = :rocketId")
    suspend fun getRocketById(rocketId: String): RocketEntity?
}