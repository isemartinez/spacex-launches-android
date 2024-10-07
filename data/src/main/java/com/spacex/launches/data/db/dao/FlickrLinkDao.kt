package com.spacex.launches.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spacex.launches.data.models.local.FlickrLinkEntity

@Dao
internal interface FlickrLinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlickrLink(flickrLink: FlickrLinkEntity): Long

    @Query("SELECT * FROM `flickr-links`")
    suspend fun getFlickrLinks(): List<FlickrLinkEntity>

    @Query("DELETE FROM `flickr-links`")
    suspend fun deleteFlickrLinks()

}