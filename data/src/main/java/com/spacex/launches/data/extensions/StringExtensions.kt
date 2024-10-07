package com.spacex.launches.data.extensions

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

/**
 * Extension function to convert a UTC date string in ISO 8601 format to a more readable format.
 * It takes a string in the format "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" and converts it to "MMMM d, yyyy".
 *
 * Example input: "2023-10-05T14:48:00.000Z"
 * Example output: "October 5, 2023"
 *
 * @receiver [String] The UTC date string in ISO 8601 format.
 * @return A formatted date string in the format "MMMM d, yyyy".
 * @throws IllegalArgumentException if the date string is in an invalid format.
 */
fun String.formatStringDateUtcToReadableDate(): String {
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    inputFormatter.timeZone = TimeZone.getTimeZone("UTC") // Set timezone to UTC
    val date = inputFormatter.parse(this)
    val outputFormatter = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
    return date?.let { outputFormatter.format(it) }
        ?: throw IllegalArgumentException("Invalid date format")
}
