package com.example.zpoc.data.datasource.remote

import com.example.zpoc.data.datasource.remote.model.CommentApiModel
import com.example.zpoc.data.datasource.remote.model.PostApiModel
import com.example.zpoc.data.datasource.remote.model.UserApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiClient {

    @GET("posts")
    fun getPost() : Observable<List<PostApiModel>>

    @GET ("users")
    fun getUsers(): Observable<List<UserApiModel>>

    @GET("comments")
    fun getComments(): Observable<List<CommentApiModel>>
}