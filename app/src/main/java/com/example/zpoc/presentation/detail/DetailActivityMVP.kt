package com.example.zpoc.presentation.detail

import com.example.zpoc.domain.model.Comment
import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.model.User
import com.example.zpoc.presentation.base.BasePresenter
import com.example.zpoc.presentation.base.BaseView
import io.reactivex.Completable
import io.reactivex.Single

class DetailActivityMVP {
    interface Presenter : BasePresenter {
        fun getData(postId: Int)
        fun makePostFavorite()
        fun makePostAlreadySeen(post: Post)
    }

    interface View : BaseView {
        fun updatePostInfo(post: Post)
        fun updateComments(comments: List<Comment>)
        fun updateUserInfo(user: User)
    }

    interface Model {
        fun getPost(postId: Int): Single<Post>
        fun getComments(postId: Int): Single<List<Comment>>
        fun getUser(userId: Int): Single<User>
        fun updatePost(post: Post): Completable
    }
}