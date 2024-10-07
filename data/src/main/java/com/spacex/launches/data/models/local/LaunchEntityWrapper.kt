package com.spacex.launches.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Represents a wrapper around a launch entity, containing additional related data from other entities.
 * This data class is used to retrieve a launch along with its associated fairings, failures, and cores in a single query.
 *
 * @property launch The main launch entity that holds the core launch data.
 * @property fairings The associated launch fairings entity, which contains information about the fairings used during the launch (optional).
 * @property failures A list of associated launch failure entities, which represent the failures that occurred during the launch (if any).
 * @property cores A list of associated launch core entities, which represent the reusable rocket cores used during the launch.
 */
internal data class LaunchEntityWrapper(

    @Embedded
    var launch: LaunchEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "launchId"
    )
    var fairings: LaunchFairingsEntity?,

    @Relation(
        parentColumn = "id",
        entityColumn = "launchId"
    )
    var failures: List<LaunchFailureEntity>,

    @Relation(
        parentColumn = "id",
        entityColumn = "launchId"
    )
    var cores: List<LaunchCoreEntity>

)
