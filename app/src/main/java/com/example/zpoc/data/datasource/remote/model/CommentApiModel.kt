package com.example.zpoc.data.datasource.remote.model

data class CommentApiModel (
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)