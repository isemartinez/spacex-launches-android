package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchEntity
import com.spacex.launches.data.models.local.LaunchEntityWrapper

@Dao
internal interface LaunchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunch(launch: LaunchEntity): Long

    @Query("SELECT * FROM launches")
    suspend fun getLaunches(): List<LaunchEntityWrapper>

    @Query("SELECT * FROM launches WHERE launchId = :launchId")
    suspend fun getLaunchByRemoteId(launchId: String): LaunchEntityWrapper?

    @Query("SELECT * FROM launches WHERE id = :id")
    suspend fun getLaunchByLocalId(id: Long): LaunchEntityWrapper?

    @Query("DELETE FROM launches")
    suspend fun deleteLaunches()
}