package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import com.example.zpoc.domain.model.Post
import io.reactivex.Completable
import javax.inject.Inject

class UpdatePostUseCase @Inject constructor(val dataRepository: DataRepository) {

    operator fun invoke(post: Post): Completable {
        return dataRepository.updatePost(post)
    }
}