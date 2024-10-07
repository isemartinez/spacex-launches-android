package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.PatchLinkEntity
import com.spacex.launches.data.models.local.RedditLinkEntity

@Dao
internal interface RedditLinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRedditLink(redditLink: RedditLinkEntity): Long

    @Query("SELECT * FROM `reddit-links`")
    suspend fun getRedditLinks(): List<PatchLinkEntity>

    @Query("DELETE FROM `reddit-links`")
    suspend fun deleteRedditLinks()
}