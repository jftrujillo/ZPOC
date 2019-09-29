package com.example.zpoc.presentation.detail.mvp

import com.example.zpoc.domain.model.Comment
import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.model.User
import com.example.zpoc.domain.usecases.GetCommentsUseCase
import com.example.zpoc.domain.usecases.GetPostIUseCase
import com.example.zpoc.domain.usecases.GetUserUseCase
import com.example.zpoc.domain.usecases.UpdatePostUseCase
import com.example.zpoc.presentation.detail.DetailActivityMVP
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DetailModel @Inject constructor(
    val getPostIUseCase: GetPostIUseCase,
    val getCommentsUseCase: GetCommentsUseCase,
    val getUserUseCase: GetUserUseCase,
    val updatePostUseCase: UpdatePostUseCase
) : DetailActivityMVP.Model {

    override fun getPost(postId: Int): Single<Post> {
        return getPostIUseCase(postId)
    }

    override fun getComments(postId: Int): Single<List<Comment>> {
        return getCommentsUseCase(postId)
    }

    override fun getUser(userId: Int): Single<User> {
        return getUserUseCase(userId)
    }

    override fun updatePost(post: Post): Completable {
        return updatePostUseCase(post)
    }
}