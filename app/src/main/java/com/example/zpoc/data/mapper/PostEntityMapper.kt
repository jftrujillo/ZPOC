package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.PostEntity
import com.example.zpoc.domain.model.Post
import javax.inject.Inject

class PostEntityMapper @Inject constructor(): BaseMapper<PostEntity, Post> {

    override fun tranformTo(inObject: PostEntity): Post {
        inObject.apply {
            return Post(userId, id, title, body, isFav, isRead)
        }
    }

    override fun transformFrom(inObject: Post): PostEntity {
        inObject.apply {
            return PostEntity(id, userId, title, body, isSeen, isFav)
        }
    }
}