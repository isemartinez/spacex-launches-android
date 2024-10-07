package com.spacex.launches.data.models.presentation

import com.spacex.launches.data.models.presentation.Launch as PresentationLaunch

sealed interface PresentationItem {

    data class Header(val title: String, val backgroundURL: String) : PresentationItem

    data class Launch(val launch: PresentationLaunch) : PresentationItem
}