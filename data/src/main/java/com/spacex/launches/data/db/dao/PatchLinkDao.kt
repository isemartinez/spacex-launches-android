package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.PatchLinkEntity

/**
 * Data Access Object (DAO) for handling operations related to the `patch-links` table.
 * This DAO provides methods to insert, retrieve, and delete patch link data from the local Room database.
 * The patch links represent image URLs (small and large) related to the launch links.
 */
@Dao
internal interface PatchLinkDao {

    /**
     * Inserts a patch link record into the `patch-links` table.
     * If a patch link with the same primary key exists, it will be replaced (OnConflictStrategy.REPLACE).
     *
     * @param patchLink A [PatchLinkEntity] object representing the patch link to be inserted.
     * @return A [Long] representing the row ID of the inserted or replaced patch link.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPatchLink(patchLink: PatchLinkEntity): Long

    /**
     * Retrieves all patch link records from the `patch-links` table.
     *
     * @return A [List] of [PatchLinkEntity] representing all patch links stored in the database.
     */
    @Query("SELECT * FROM `patch-links`")
    suspend fun getPatchLinks(): List<PatchLinkEntity>

    /**
     * Deletes all patch link records from the `patch-links` table.
     * This will remove all entries and leave the table empty.
     */
    @Query("DELETE FROM `patch-links`")
    suspend fun deletePatchLinks()

}
