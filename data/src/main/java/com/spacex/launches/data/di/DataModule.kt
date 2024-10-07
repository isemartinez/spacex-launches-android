package com.spacex.launches.data.di

import android.content.Context
import androidx.room.Room
import com.spacex.launches.data.api.SpaceXApiService
import com.spacex.launches.data.db.AppDatabase
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
import com.spacex.launches.data.mappers.dtoentity.DtoToEntityMapper
import com.spacex.launches.data.mappers.dtoentity.DtoToEntityMapperImpl
import com.spacex.launches.data.mappers.entitypresentation.EntityToPresentationMapper
import com.spacex.launches.data.mappers.entitypresentation.EntityToPresentationMapperImpl
import com.spacex.launches.data.network.RetrofitClient
import com.spacex.launches.data.repository.SpaceXRepository
import com.spacex.launches.data.repository.SpaceXRepositoryImpl
import com.spacex.launches.data.repository.network.NetworkRepository
import com.spacex.launches.data.repository.network.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    internal fun providesSpaceXApiService(): SpaceXApiService {
        return RetrofitClient.retrofit.create(SpaceXApiService::class.java)
    }

    @Provides
    @Singleton
    internal fun providesDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    internal fun providesLaunchDtoToEntityMapper(): DtoToEntityMapper {
        return DtoToEntityMapperImpl()
    }

    @Provides
    @Singleton
    internal fun providesLaunchEntityToLaunchMapper(): EntityToPresentationMapper {
        return EntityToPresentationMapperImpl()
    }

    @Provides
    @Singleton
    internal fun providesLaunchDao(database: AppDatabase): LaunchDao {
        return database.launchDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchFairingsDao(database: AppDatabase): LaunchFairingsDao {
        return database.launchFairingsDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchFailuresDao(database: AppDatabase): LaunchFailureDao {
        return database.launchFailuresDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchLinksDao(database: AppDatabase): LaunchLinksDao {
        return database.launchLinksDao()
    }

    @Provides
    @Singleton
    internal fun providesFlickrLinkDao(database: AppDatabase): FlickrLinkDao {
        return database.flickrLinkDao()
    }

    @Provides
    @Singleton
    internal fun providesPatchLinkDao(database: AppDatabase): PatchLinkDao {
        return database.patchLinkDao()
    }

    @Provides
    @Singleton
    internal fun providesRedditLinkDao(database: AppDatabase): RedditLinkDao {
        return database.redditLinkDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchCoreDao(database: AppDatabase): LaunchCoreDao {
        return database.launchCoreDao()
    }

    @Provides
    @Singleton
    internal fun providesRocketDao(database: AppDatabase): RocketDao {
        return database.rocketDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchPadDao(database: AppDatabase): LaunchPadDao {
        return database.launchPadDao()
    }

    @Provides
    @Singleton
    internal fun providesLaunchRepository(
        dtoToEntityMapper: DtoToEntityMapper,
        entityToPresentationMapper: EntityToPresentationMapper,
        spaceXApiService: SpaceXApiService,
        launchDao: LaunchDao,
        launchFailureDao: LaunchFailureDao,
        launchLinksDao: LaunchLinksDao,
        patchLinkDao: PatchLinkDao,
        redditLinkDao: RedditLinkDao,
        flickrLinkDao: FlickrLinkDao,
        launchCoreDao: LaunchCoreDao,
        launchFairingsDao: LaunchFairingsDao,
        rocketDao: RocketDao,
        launchPadDao: LaunchPadDao
    ): SpaceXRepository {
        return SpaceXRepositoryImpl(
            dtoToEntityMapper = dtoToEntityMapper,
            entityToPresentationMapper = entityToPresentationMapper,
            apiService = spaceXApiService,
            launchDao = launchDao,
            launchFailureDao = launchFailureDao,
            launchLinksDao = launchLinksDao,
            patchLinkDao = patchLinkDao,
            redditLinkDao = redditLinkDao,
            flickrLinkDao = flickrLinkDao,
            launchCoreDao = launchCoreDao,
            launchFairingsDao = launchFairingsDao,
            rocketDao = rocketDao,
            launchPadDao = launchPadDao
        )
    }

    @Provides
    @Singleton
    fun providesNetworkRepository(@ApplicationContext context: Context): NetworkRepository {
        return NetworkRepositoryImpl(context)
    }
}