package com.spacex.launches.data.mappers.entitypresentation

import com.spacex.launches.data.extensions.formatStringDateUtcToReadableDate
import com.spacex.launches.data.models.local.LaunchEntityWrapper
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.RocketEntity
import com.spacex.launches.data.models.presentation.Launch

internal class EntityToPresentationMapperImpl : EntityToPresentationMapper {
    override fun mapLaunches(launches: List<LaunchEntityWrapper>): List<Launch> {
        return launches.map { launch ->
            mapLaunch(launchEntityWrapper = launch)
        }
    }

    override fun mapLaunch(
        launchEntityWrapper: LaunchEntityWrapper,
        rocketEntity: RocketEntity?,
        launchPadEntity: LaunchPadEntity?
    ): Launch {
        return Launch(
            id = launchEntityWrapper.launch.id,
            flightNumber = launchEntityWrapper.launch.flightNumber.toString(),
            missionName = "${launchEntityWrapper.launch.name.uppercase()} MISSION",
            rocketName = rocketEntity?.name?.uppercase() ?: "",
            rocketType = rocketEntity?.type?.uppercase() ?: "",
            launchSiteName = launchPadEntity?.fullName?.uppercase() ?: "",
            flightDetails = launchEntityWrapper.launch.details,
            launchPadImageURL = launchPadEntity?.imageURL ?: "",
            launchDate = launchEntityWrapper.launch.dateUtc?.formatStringDateUtcToReadableDate()?.uppercase() ?: ""
        )
    }
}