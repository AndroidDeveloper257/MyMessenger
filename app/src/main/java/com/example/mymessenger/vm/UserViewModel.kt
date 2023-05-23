package com.example.mymessenger.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymessenger.database.entity.UserEntity
import com.example.mymessenger.networking.NetworkHelper
import com.example.mymessenger.networking.UserService
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class UserViewModel(
    private val userService: UserService,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private var liveData = MutableLiveData<UserResource>(UserResource.Loading)

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        if (networkHelper.isNetworkConnected()) {
            userService
                .getUsers()
                .addValueEventListener(
                    object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                /**
                                 * there is something in firebase
                                 */
                                val emptyList = ArrayList<UserEntity>()
                                snapshot.children.forEach { dataSnapshot ->
                                    val user = dataSnapshot.getValue(UserEntity::class.java)
                                    if (user != null) {
                                        emptyList.add(user)
                                    }
                                }
                                liveData.postValue(UserResource.Success(emptyList))
                            } else {
                                liveData.postValue(UserResource.Success(ArrayList()))
                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                            liveData.postValue(UserResource.Error(Throwable(error.message)))
                        }

                    }
                )
        } else {
            liveData.postValue(UserResource.Error(Throwable("No internet connection")))
        }
    }

    fun getLiveData(): LiveData<UserResource> {
        return liveData
    }
}