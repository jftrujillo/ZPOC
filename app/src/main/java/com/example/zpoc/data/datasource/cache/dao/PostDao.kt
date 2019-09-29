package com.example.zpoc.data.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.zpoc.data.datasource.cache.entity.PostEntity
import io.reactivex.Observable

@Dao
interface PostDao: BaseDao<PostEntity> {
    @Query ("SELECT * FROM post")
    fun getAll(): Observable<List<PostEntity>>

    @Query("SELECT * FROM post where id = :postId")
    fun getPostById(postId: Int): Observable<PostEntity>
}