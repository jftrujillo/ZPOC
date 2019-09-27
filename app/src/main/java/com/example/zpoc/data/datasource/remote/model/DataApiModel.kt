package com.example.zpoc.data.datasource.remote.model

data class DataApiModel(
    val posts: List<PostApiModel>,
    val users: List<UserApiModel>,
    val comments: List<CommentApiModel>
)