package com.example.zpoc.data.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.zpoc.data.datasource.cache.entity.UserEntity
import io.reactivex.Observable

@Dao
interface UserDao: BaseDao<UserEntity> {

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserById(userId: Int): Observable<UserEntity>
}