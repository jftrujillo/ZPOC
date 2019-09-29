package com.example.zpoc.data.datasource.remote.model

data class CommentApiModel (
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    val body: String
)