package com.example.mymessenger.vm

sealed class UserResource<T> {

    class Loading<T> : UserResource<T>()

    class Success<T : Any>(val data: T) : UserResource<T>()

    class Error<T : Any>(val e: Throwable) : UserResource<T>()

}