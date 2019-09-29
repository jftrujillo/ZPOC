package com.example.zpoc.data

import com.example.zpoc.data.datasource.remote.model.DataApiModel
import com.example.zpoc.domain.model.Comment
import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface DataRepository {
    fun retrieveDataFromServer(): Completable

    fun getAllPost(): Observable<List<Post>>

    fun getPost(postId: Int): Observable<Post>

    fun getCommentsByPostId(postId: Int): Observable<List<Comment>>

    fun getUserById(userId: Int): Observable<User>

    fun updatePost(post: Post): Completable

    fun cleanDatabase(): Completable

}