package com.example.hiltmvvm.utils

sealed class NetworkResource<out T>(data: T?, message: String?) {

    data class Success<T>(val data: T) : NetworkResource<T>(data, null)
    data class Error<T>(val message: String?) : NetworkResource<T>(null, message)
    object Loading : NetworkResource<Nothing>(null, null)

}
