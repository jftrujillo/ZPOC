package com.example.zpoc.domain.model

data class Post (
    val userId: Int,
    val id: Int,
    val title: String,
    val body:String,
    var isFav: Boolean = false,
    var isSeen: Boolean = false
)