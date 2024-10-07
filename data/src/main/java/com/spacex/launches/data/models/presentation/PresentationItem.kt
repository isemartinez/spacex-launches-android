package com.spacex.launches.data.models.presentation

import com.spacex.launches.data.models.presentation.Launch as PresentationLaunch

/**
 * Represents a sealed interface that defines different types of items used in the presentation layer.
 * This allows grouping of different UI components (e.g., headers and launch details) under a single type.
 */
sealed interface PresentationItem {

    /**
     * Represents a header item used in the presentation layer.
     * Typically used for displaying a section header with a title and background image.
     *
     * @property title The title of the header.
     * @property backgroundURL The URL of the background image for the header.
     */
    data class Header(val title: String, val backgroundURL: String) : PresentationItem

    /**
     * Represents a launch item used in the presentation layer.
     * Encapsulates the details of a specific launch.
     *
     * @property launch The [Launch] object containing the details of the SpaceX launch.
     */
    data class Launch(val launch: PresentationLaunch) : PresentationItem
}
