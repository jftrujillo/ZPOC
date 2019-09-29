package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.PostEntity
import com.example.zpoc.data.datasource.remote.model.PostApiModel
import javax.inject.Inject

class PostApiModelMapper @Inject constructor(): BaseMapper<PostApiModel, PostEntity>{
    override fun tranformTo(inObject: PostApiModel): PostEntity {
        inObject.apply {
            return PostEntity(id, userId, title, body)
        }

    }

    override fun transformFrom(inObject: PostEntity): PostApiModel {
        inObject.apply {
            return PostApiModel(userId, id, title, body)
        }
    }
}