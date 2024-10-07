package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.LaunchLinksEntity
import com.spacex.launches.data.models.local.LaunchLinksWrapper

@Dao
internal interface LaunchLinksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchLinks(launchLink: LaunchLinksEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunchLinks(launchLinks: List<LaunchLinksEntity>): List<Long>

    @Query("SELECT * FROM `launch-links`")
    suspend fun getLaunchLinks(): List<LaunchLinksWrapper>

    @Query("DELETE FROM `launch-links`")
    suspend fun deleteLaunchLinks()

}