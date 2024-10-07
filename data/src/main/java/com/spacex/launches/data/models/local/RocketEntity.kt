package com.spacex.launches.data.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rockets")
data class RocketEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val rocketId: String,
    val name: String,
    val type: String,
    val active: Boolean,
    val country: String,
    val company: String,
    val wikipedia: String,
    val description: String
)
