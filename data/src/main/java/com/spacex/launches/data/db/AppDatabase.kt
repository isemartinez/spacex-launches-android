package com.spacex.launches.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spacex.launches.data.db.dao.FlickrLinkDao
import com.spacex.launches.data.db.dao.LaunchCoreDao
import com.spacex.launches.data.db.dao.LaunchDao
import com.spacex.launches.data.db.dao.LaunchFailureDao
import com.spacex.launches.data.db.dao.LaunchFairingsDao
import com.spacex.launches.data.db.dao.LaunchLinksDao
import com.spacex.launches.data.db.dao.LaunchPadDao
import com.spacex.launches.data.db.dao.PatchLinkDao
import com.spacex.launches.data.db.dao.RedditLinkDao
import com.spacex.launches.data.db.dao.RocketDao
import com.spacex.launches.data.models.local.FlickrLinkEntity
import com.spacex.launches.data.models.local.LaunchCoreEntity
import com.spacex.launches.data.models.local.LaunchEntity
import com.spacex.launches.data.models.local.LaunchFailureEntity
import com.spacex.launches.data.models.local.LaunchFairingsEntity
import com.spacex.launches.data.models.local.LaunchLinksEntity
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.PatchLinkEntity
import com.spacex.launches.data.models.local.RedditLinkEntity
import com.spacex.launches.data.models.local.RocketEntity

@Database(
    entities = [
        LaunchEntity::class,
        LaunchFairingsEntity::class,
        LaunchFailureEntity::class,
        LaunchLinksEntity::class,
        FlickrLinkEntity::class,
        PatchLinkEntity::class,
        RedditLinkEntity::class,
        LaunchCoreEntity::class,
        RocketEntity::class,
        LaunchPadEntity::class
    ],
    version = 1,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun launchDao(): LaunchDao

    abstract fun launchFairingsDao(): LaunchFairingsDao

    abstract fun launchFailuresDao(): LaunchFailureDao

    abstract fun launchLinksDao(): LaunchLinksDao

    abstract fun flickrLinkDao(): FlickrLinkDao

    abstract fun patchLinkDao(): PatchLinkDao

    abstract fun redditLinkDao(): RedditLinkDao

    abstract fun launchCoreDao(): LaunchCoreDao

    abstract fun rocketDao(): RocketDao

    abstract fun launchPadDao(): LaunchPadDao

    companion object {
        const val DATABASE_NAME = "spacex_launches_database"
    }

}