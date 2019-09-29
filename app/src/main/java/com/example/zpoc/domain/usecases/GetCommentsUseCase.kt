package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import com.example.zpoc.domain.model.Comment
import io.reactivex.Single
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(val dataRepository: DataRepository) {

    operator fun invoke(postId: Int) : Single<List<Comment>> {
        return dataRepository.getCommentsByPostId(postId).firstOrError()
    }
}