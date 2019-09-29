package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.UserEntity
import com.example.zpoc.domain.model.User
import javax.inject.Inject

class UserEntityMapper @Inject constructor(): BaseMapper<UserEntity, User> {

    override fun transformFrom(inObject: User): UserEntity {
        inObject.apply {
            return UserEntity(id, username, email, phone, website)
        }
    }

    override fun tranformTo(inObject: UserEntity): User {
        inObject.apply {
            return User(id, username, email, phone, website)
        }
    }
}