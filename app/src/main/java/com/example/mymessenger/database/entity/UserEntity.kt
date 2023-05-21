package com.example.mymessenger.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users_table"
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long? = null,
    @ColumnInfo(name = "first_name")
    val firstName: String? = null,
    @ColumnInfo(name = "last_name")
    val lastName: String? = null,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String? = null,
    @ColumnInfo(name = "profile_photo_url")
    val profilePhotoUrl: String? = null,
    @ColumnInfo(name = "profile_background_color")
    val profileBackgroundColor: Int? = null,
    @ColumnInfo(name = "is_online")
    val isOnline: Boolean? = null,
    @ColumnInfo(name = "token")
    val token: String? = null
)