package com.example.zpoc.data.datasource.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zpoc.data.datasource.cache.dao.CommentDao
import com.example.zpoc.data.datasource.cache.dao.PostDao
import com.example.zpoc.data.datasource.cache.dao.UserDao
import com.example.zpoc.data.datasource.cache.entity.CommentEntity
import com.example.zpoc.data.datasource.cache.entity.PostEntity
import com.example.zpoc.data.datasource.cache.entity.UserEntity

@Database(entities = [CommentEntity::class, PostEntity::class, UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao
    abstract fun postDao(): PostDao
    abstract fun userDao(): UserDao
}