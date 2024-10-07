package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchPadEntity

@Dao
interface LaunchPadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchPad(launchPad: LaunchPadEntity): Long

    @Query("SELECT * FROM launchpads WHERE launchpadId = :id")
    suspend fun getLaunchPadById(id: String): LaunchPadEntity?

    @Query("DELETE FROM launchpads")
    suspend fun deleteLaunchPads()

    @Query("SELECT * FROM launchpads")
    suspend fun getLaunchPads(): List<LaunchPadEntity>

}