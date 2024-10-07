package com.spacex.launches.data.models.local

import androidx.room.Embedded
import androidx.room.Relation

internal data class LaunchEntityWrapper(

    @Embedded
    var launch: LaunchEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "launchId"
    )
    var fairings: LaunchFairingsEntity?,
   /*@Relation(
        parentColumn = "id",
        entityColumn = "launchId"
    )
    var links: LaunchLinksWrapper,*/
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