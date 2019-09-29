package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import com.example.zpoc.domain.model.User
import io.reactivex.Single
import javax.inject.Inject

class GetUserUseCase @Inject constructor(val dataRepository: DataRepository) {

    operator fun invoke(userId: Int): Single<User> {
        return dataRepository.getUserById(userId).firstOrError()
    }
}