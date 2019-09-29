package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import com.example.zpoc.domain.model.Post
import io.reactivex.Single
import javax.inject.Inject

class GetPostIUseCase @Inject constructor(private val dataRepository: DataRepository) {

    operator fun invoke(postId: Int): Single<Post> {
        return dataRepository.getPost(postId).firstOrError()
    }
}