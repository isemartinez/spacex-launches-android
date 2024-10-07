package com.spacex.launches.data.mappers.entitypresentation

import com.spacex.launches.data.models.local.LaunchEntityWrapper
import com.spacex.launches.data.models.local.LaunchPadEntity
import com.spacex.launches.data.models.local.RocketEntity
import com.spacex.launches.data.models.presentation.Launch

/**
 * Interface that defines methods for mapping local database entities to presentation models.
 * The goal of this interface is to convert local Room entities into models that can be used in the UI layer.
 */
internal interface EntityToPresentationMapper {

    /**
     * Maps a list of launch entity wrappers to a list of presentation models.
     *
     * @param launches A list of [LaunchEntityWrapper] representing launches from the local database.
     * @return A list of [Launch] objects that represent the presentation layer models used in the UI.
     */
    fun mapLaunches(launches: List<LaunchEntityWrapper>): List<Launch>

    /**
     * Maps a single launch entity wrapper to a presentation model.
     * Optionally, a rocket entity and a launch pad entity can be included for additional data.
     *
     * @param launchEntityWrapper A [LaunchEntityWrapper] representing a single launch from the local database.
     * @param rocketEntity An optional [RocketEntity] representing the rocket used in the launch.
     * @param launchPadEntity An optional [LaunchPadEntity] representing the launch pad used for the launch.
     * @return A [Launch] object that represents the presentation model used in the UI.
     */
    fun mapLaunch(
        launchEntityWrapper: LaunchEntityWrapper,
        rocketEntity: RocketEntity? = null,
        launchPadEntity: LaunchPadEntity? = null
    ): Launch
}
