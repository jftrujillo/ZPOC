package com.example.zpoc.presentation.detail.mvp

import com.example.zpoc.domain.model.Post
import com.example.zpoc.presentation.base.BaseView
import com.example.zpoc.presentation.detail.DetailActivityMVP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class DetailPresenter @Inject constructor(val model: DetailActivityMVP.Model) :
    DetailActivityMVP.Presenter {

    lateinit var view: DetailActivityMVP.View
    lateinit var post: Post

    val disposable: CompositeDisposable = CompositeDisposable()


    override fun getData(postId: Int) {

        disposable.add(
            model.getPost(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    post = it
                    view.updatePostInfo(it)
                    getUserInfo(it)
                },
                    {
                        handleError(it.message)
                    })
        )

        disposable.add(
            model.getComments(postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.updateComments(it)
                }, {
                    handleError(it.message)
                })
        )

    }

    private fun getUserInfo(post: Post) {
        disposable.add(
            model.getUser(post.userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.updateUserInfo(it)
                },
                    {
                        handleError(it.message)
                    })
        )
    }

    override fun makePostFavorite() {
        post.isFav = post.isFav.not()
        disposable.add(model.updatePost(post)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }

    override fun makePostAlreadySeen(post: Post) {
        post.isSeen = true
        disposable.add(model.updatePost(post)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe())
    }


    override fun setView(view: BaseView) {
        this.view = view as DetailActivityMVP.View
    }

    override fun disposeObservers() {
        disposable.dispose()
    }

    override fun init() {

    }

    private fun handleError(message: String?) {
        view.onError(message ?: "ERROR")
    }
}