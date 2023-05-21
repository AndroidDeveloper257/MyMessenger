package com.example.mymessenger.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mymessenger.database.dao.UserDao
import com.example.mymessenger.database.entity.UserEntity

@Database(
    entities =
    [
        UserEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(context, AppDatabase::class.java, "messenger_database")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE!!
        }
    }
}