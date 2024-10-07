package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.PatchLinkEntity

@Dao
internal interface PatchLinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatchLink(patchLink: PatchLinkEntity): Long

    @Query("SELECT * FROM `patch-links`")
    suspend fun getPatchLinks(): List<PatchLinkEntity>

    @Query("DELETE FROM `patch-links`")
    suspend fun deletePatchLinks()

}