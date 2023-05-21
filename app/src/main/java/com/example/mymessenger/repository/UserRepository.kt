package com.example.mymessenger.repository

import com.example.mymessenger.database.entity.UserEntity
import com.example.mymessenger.networking.UserService

class UserRepository(
    private val userService: UserService
) {

    fun getUsers() = userService.getUsers()

    fun addUser(userEntity: UserEntity) = userService.addUser(userEntity)

}