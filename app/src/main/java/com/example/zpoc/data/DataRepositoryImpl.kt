package com.example.zpoc.data

import com.example.zpoc.data.datasource.remote.ApiClient
import com.example.zpoc.data.datasource.remote.model.CommentApiModel
import com.example.zpoc.data.datasource.remote.model.DataApiModel
import com.example.zpoc.data.datasource.remote.model.PostApiModel
import com.example.zpoc.data.datasource.remote.model.UserApiModel
import com.example.zpoc.domain.DataRepository
import io.reactivex.Observable
import io.reactivex.functions.Function3
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(private val apiClient: ApiClient ): DataRepository {

    fun retrieveDataFromServer(): Observable<DataApiModel> {
        return Observable.zip(
            apiClient.getUsers(),
            apiClient.getComments(),
            apiClient.getPost(),
            Function3<List<UserApiModel>, List<CommentApiModel>, List<PostApiModel>, DataApiModel> { users, comments, posts ->
                return@Function3 DataApiModel( posts, users, comments)
            }
        )
    }
}