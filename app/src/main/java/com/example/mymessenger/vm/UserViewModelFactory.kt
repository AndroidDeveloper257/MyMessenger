package com.example.mymessenger.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymessenger.networking.NetworkHelper
import com.example.mymessenger.networking.UserService

class UserViewModelFactory(
    private val userService: UserService,
    private val networkHelper: NetworkHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(
                userService = userService,
                networkHelper = networkHelper
            ) as T
        }
        return throw Exception("Error")
    }
}