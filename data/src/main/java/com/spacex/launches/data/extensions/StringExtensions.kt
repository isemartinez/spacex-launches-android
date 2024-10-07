package com.spacex.launches.data.extensions

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

fun String.formatStringDateUtcToReadableDate(): String {
    val inputFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    inputFormatter.timeZone = TimeZone.getTimeZone("UTC")
    val date = inputFormatter.parse(this)
    val outputFormatter = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault())
    return date?.let { outputFormatter.format(it) }
        ?: throw IllegalArgumentException("Invalid date format")
}