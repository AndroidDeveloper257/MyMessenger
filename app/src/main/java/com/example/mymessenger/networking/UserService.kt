package com.example.mymessenger.networking

import com.example.mymessenger.database.entity.UserEntity
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference

interface UserService {

    fun getUsers(): DatabaseReference

    fun addUser(userEntity: UserEntity): Task<Void>

}