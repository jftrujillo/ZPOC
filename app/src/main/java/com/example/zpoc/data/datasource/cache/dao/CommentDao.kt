package com.example.zpoc.data.datasource.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.zpoc.data.datasource.cache.entity.CommentEntity
import io.reactivex.Observable

@Dao
interface CommentDao: BaseDao<CommentEntity> {

    @Query("SELECT * FROM comment WHERE post_id = :postId ")
    fun findCommentsByPostId(postId: Int): Observable<List<CommentEntity>>
}