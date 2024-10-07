package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchFailureEntity

@Dao
internal interface LaunchFailureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchFailures(launchFailures: List<LaunchFailureEntity>): List<Long>

    @Query("SELECT * FROM `launch-failures`")
    suspend fun getLaunchFailures(): List<LaunchFailureEntity>

    @Query("DELETE FROM `launch-failures`")
    suspend fun deleteLaunchFailures()

}