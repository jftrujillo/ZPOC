package com.example.zpoc.presentation.home.mvp

import com.example.zpoc.presentation.base.BaseView
import com.example.zpoc.presentation.home.HomeActivityMVP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val homeModel: HomeModel
) : HomeActivityMVP.Presenter {

    val compositeDisposable = CompositeDisposable()

    lateinit var view: HomeActivityMVP.View

    override fun setView(view: BaseView) {
        this.view = view as HomeActivityMVP.View
    }


    override fun updateData() {
        compositeDisposable.add(homeModel.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                updatePost()
            }, {
                onError(it.message)
            })
        )
    }

    override fun getPost() {
        updatePost()
    }

    override fun deleteAllPost() {
        compositeDisposable.add(
            homeModel.deleteAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    updatePost()
                },{
                    onError(it.message)
                })
        )
    }


    private fun updatePost() {
        compositeDisposable.add(
            homeModel.updatePost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isEmpty()) {
                        view.notifyNoPostFound()
                    } else {
                        view.notifyPostChanged(it)
                    }
                }, {
                    onError(it.message)
                })
        )
    }

    override fun disposeObservers() {
        compositeDisposable.dispose()
    }

    override fun init() {
        updatePost()
    }

    private fun onError(message: String?) {
        view.onError(message ?: "Error")
    }


}