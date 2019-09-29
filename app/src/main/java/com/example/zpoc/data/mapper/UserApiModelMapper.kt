package com.example.zpoc.data.mapper

import com.example.zpoc.data.datasource.cache.entity.UserEntity
import com.example.zpoc.data.datasource.remote.model.UserApiModel
import javax.inject.Inject

class UserApiModelMapper @Inject constructor(): BaseMapper<UserApiModel, UserEntity > {

    override fun tranformTo(inObject: UserApiModel): UserEntity {
        inObject.apply {
            return UserEntity(id, username, email, phone, website)
        }
    }

    override fun transformFrom(inObject: UserEntity): UserApiModel {
        inObject.apply {
            return UserApiModel(id, username, email, phone, website)
        }
    }
}