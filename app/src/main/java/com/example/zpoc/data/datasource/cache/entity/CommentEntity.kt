package com.example.zpoc.data.datasource.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "comment")
data class CommentEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "post_id") val postId: Int,
    @ColumnInfo (name = "name") val name: String,
    @ColumnInfo( name = "email") val email: String,
    @ColumnInfo( name = "body") val body: String
)