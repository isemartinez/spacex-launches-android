package com.spacex.launches.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spacex.launches.data.db.dao.*
import com.spacex.launches.data.models.local.*

/**
 * The central database class for the SpaceX launches app, which extends RoomDatabase.
 * This class is responsible for providing access to the DAOs and managing the defined entities.
 * It contains all the entities related to SpaceX launches, such as launch data, rockets, launchpads, and various links.
 *
 * Entities included in the database:
 * - LaunchEntity
 * - LaunchFairingsEntity
 * - LaunchFailureEntity
 * - LaunchLinksEntity
 * - FlickrLinkEntity
 * - PatchLinkEntity
 * - RedditLinkEntity
 * - LaunchCoreEntity
 * - RocketEntity
 * - LaunchPadEntity
 *
 * Version: 1
 * Schema export: false (used for local persistence only)
 */
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

    /**
     * Provides access to operations related to the `launches` table.
     * @return [LaunchDao] to interact with the Launch data.
     */
    abstract fun launchDao(): LaunchDao

    /**
     * Provides access to operations related to the `launch-fairings` table.
     * @return [LaunchFairingsDao] to interact with the Launch Fairings data.
     */
    abstract fun launchFairingsDao(): LaunchFairingsDao

    /**
     * Provides access to operations related to the `launch-failures` table.
     * @return [LaunchFailureDao] to interact with the Launch Failures data.
     */
    abstract fun launchFailuresDao(): LaunchFailureDao

    /**
     * Provides access to operations related to the `launch-links` table.
     * @return [LaunchLinksDao] to interact with the Launch Links data.
     */
    abstract fun launchLinksDao(): LaunchLinksDao

    /**
     * Provides access to operations related to the `flickr-links` table.
     * @return [FlickrLinkDao] to interact with the Flickr Links data.
     */
    abstract fun flickrLinkDao(): FlickrLinkDao

    /**
     * Provides access to operations related to the `patch-links` table.
     * @return [PatchLinkDao] to interact with the Patch Links data.
     */
    abstract fun patchLinkDao(): PatchLinkDao

    /**
     * Provides access to operations related to the `reddit-links` table.
     * @return [RedditLinkDao] to interact with the Reddit Links data.
     */
    abstract fun redditLinkDao(): RedditLinkDao

    /**
     * Provides access to operations related to the `launch-cores` table.
     * @return [LaunchCoreDao] to interact with the Launch Core data.
     */
    abstract fun launchCoreDao(): LaunchCoreDao

    /**
     * Provides access to operations related to the `rockets` table.
     * @return [RocketDao] to interact with the Rocket data.
     */
    abstract fun rocketDao(): RocketDao

    /**
     * Provides access to operations related to the `launchpads` table.
     * @return [LaunchPadDao] to interact with the Launch Pad data.
     */
    abstract fun launchPadDao(): LaunchPadDao

    companion object {
        /**
         * The name of the database file used by Room.
         */
        const val DATABASE_NAME = "spacex_launches_database"
    }

}
