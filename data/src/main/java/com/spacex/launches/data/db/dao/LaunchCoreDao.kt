package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchCoreEntity

@Dao
internal interface LaunchCoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchCores(launchCores: List<LaunchCoreEntity>): List<Long>

    @Query("SELECT * FROM `launch-cores`")
    suspend fun getLaunchCores(): List<LaunchCoreEntity>

    @Query("DELETE FROM `launch-cores`")
    suspend fun deleteLaunchCores()

}