package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.CommentEntity
import com.example.zpoc.data.datasource.remote.model.CommentApiModel
import javax.inject.Inject

class CommentApiModelMapper @Inject constructor(): BaseMapper<CommentApiModel, CommentEntity> {

    override fun tranformTo(inObject: CommentApiModel): CommentEntity {
        inObject.apply {
            return CommentEntity(id, postId, name, email,  body)
        }
    }

    override fun transformFrom(inObject: CommentEntity): CommentApiModel {
        inObject.apply {
            return CommentApiModel(id, postId, name, email, body)
        }
    }
}