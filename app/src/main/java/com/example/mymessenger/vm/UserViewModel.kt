package com.example.mymessenger.vm

import androidx.lifecycle.ViewModel
import com.example.mymessenger.database.entity.UserEntity
import com.example.mymessenger.networking.NetworkHelper
import com.example.mymessenger.networking.UserService
import com.example.mymessenger.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class UserViewModel(
    private val userService: UserService,
    private val networkHelper: NetworkHelper,
    private val userEntity: UserEntity
) :
    ViewModel(){

    private val userRepository = UserRepository(userService)
    private val userStateFlow =
        MutableStateFlow<UserResource<List<UserEntity>>>(UserResource.Loading())

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        // TODO: should end this with live data
    }
}

