package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.CommentEntity
import com.example.zpoc.domain.model.Comment
import javax.inject.Inject

class CommentEntityMapper @Inject constructor(): BaseMapper<CommentEntity, Comment> {
    override fun tranformTo(inObject: CommentEntity): Comment {
        inObject.apply {
            return Comment(id, postId, name, email, body)
        }
    }

    override fun transformFrom(inObject: Comment): CommentEntity {
        inObject.apply {
            return CommentEntity(id, postId, name, email, body)
        }
    }
}