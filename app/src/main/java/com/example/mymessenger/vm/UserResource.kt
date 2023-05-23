package com.example.mymessenger.vm

import com.example.mymessenger.database.entity.UserEntity

sealed class UserResource {

    object Loading : UserResource()

    data class Success(val userList: ArrayList<UserEntity>) : UserResource()

    data class Error(val e: Throwable) : UserResource()

}