package com.spacex.launches.data.states

/**
 * A sealed class representing the result of an operation, either successful or failed.
 * It contains two subclasses: [Success] for successful operations and [Error] for failures.
 *
 * @param T The type of data returned in case of a successful operation.
 */
sealed class Result<out T> {

    /**
     * Represents a successful result of an operation, holding the resulting data.
     *
     * @param data The data retrieved or produced by the operation.
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * Represents an error result of an operation, holding an exception that caused the failure.
     *
     * @param exception The [Throwable] that caused the operation to fail.
     */
    data class Error(val exception: Throwable) : Result<Nothing>()
}
