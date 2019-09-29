package com.example.zpoc.presentation.home.mvp

import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.usecases.DeleteAllPostUseCase
import com.example.zpoc.domain.usecases.GetAllPostUseCase
import com.example.zpoc.domain.usecases.SyncDataUseCase
import com.example.zpoc.presentation.home.HomeActivityMVP
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class HomeModel @Inject constructor(
    private val syncDataUseCase: SyncDataUseCase,
    private val getAllPostUseCase: GetAllPostUseCase,
    private val deleteAllPostUseCase: DeleteAllPostUseCase
) : HomeActivityMVP.Model {
    override fun deleteAllPost(): Completable {
        return deleteAllPostUseCase()
    }

    override fun updatePost(): Single<List<Post>> {
        return getAllPostUseCase().firstOrError()
    }

    override fun fetchData(): Completable {
        return syncDataUseCase()
    }


}