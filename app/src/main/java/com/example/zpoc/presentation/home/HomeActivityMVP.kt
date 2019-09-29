package com.example.zpoc.presentation.home

import com.example.zpoc.domain.model.Post
import com.example.zpoc.presentation.base.BasePresenter
import com.example.zpoc.presentation.base.BaseView
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class HomeActivityMVP {
    interface Presenter : BasePresenter {
        fun updateData()
        fun getPost()
        fun deleteAllPost()

    }

    interface View: BaseView {
        fun notifyPostChanged(post: List<Post>)
        fun notifyNoPostFound()
    }

    interface Model {
        fun fetchData() : Completable
        fun updatePost(): Single<List<Post>>
        fun deleteAllPost(): Completable
    }
}