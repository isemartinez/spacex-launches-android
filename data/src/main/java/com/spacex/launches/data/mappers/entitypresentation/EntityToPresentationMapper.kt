package com.spacex.launches.data.mappers.entitypresentation

import com.spacex.launches.data.models.local.LaunchEntityWrapper
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.RocketEntity
import com.spacex.launches.data.models.presentation.Launch

internal interface EntityToPresentationMapper {

    fun mapLaunches(launches: List<LaunchEntityWrapper>): List<Launch>

    fun mapLaunch(launchEntityWrapper: LaunchEntityWrapper, rocketEntity: RocketEntity? = null,  launchPadEntity: LaunchPadEntity? = null): Launch
}