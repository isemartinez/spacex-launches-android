package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchFairingsEntity

@Dao
internal interface LaunchFairingsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchFairings(launchFairings: LaunchFairingsEntity): Long

    @Query("SELECT * FROM `launch-fairings`")
    suspend fun getLaunchFairings(): List<LaunchFairingsEntity>

    @Query("DELETE FROM `launch-fairings`")
    suspend fun deleteLaunchFairings()

}