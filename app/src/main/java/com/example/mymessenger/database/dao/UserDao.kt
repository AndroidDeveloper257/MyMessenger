package com.example.mymessenger.database.dao

import androidx.room.*
import com.example.mymessenger.database.entity.UserEntity

@Dao
interface UserDao {
    @Insert(
        entity = UserEntity::class,
        onConflict = OnConflictStrategy.REPLACE
    )
    fun addUser(userEntity: UserEntity)

    @Insert(
        entity = UserEntity::class,
        onConflict = OnConflictStrategy.REPLACE
    )
    fun addUsers(userList: ArrayList<UserEntity>)

    @Update(
        entity = UserEntity::class,
        onConflict = OnConflictStrategy.REPLACE
    )
    fun updateUser(userEntity: UserEntity)

    @Delete(
        entity = UserEntity::class
    )
    fun deleteUser(userEntity: UserEntity)

    @Query(
        "SELECT * FROM users_table"
    )
    fun getUser(): UserEntity


}