package com.example.zpoc.data

import com.example.zpoc.data.datasource.cache.AppDatabase
import com.example.zpoc.data.datasource.remote.ApiClient
import com.example.zpoc.data.datasource.remote.model.CommentApiModel
import com.example.zpoc.data.datasource.remote.model.PostApiModel
import com.example.zpoc.data.datasource.remote.model.UserApiModel
import com.example.zpoc.data.mapper.*
import com.example.zpoc.domain.model.Comment
import com.example.zpoc.domain.model.Post
import com.example.zpoc.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.Function3
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val database: AppDatabase,
    private val commentApiModelMapper: CommentApiModelMapper,
    private val postApiModelMapper: PostApiModelMapper,
    private val userApiModelMapper: UserApiModelMapper,
    private val commentEntityMapper: CommentEntityMapper,
    private val postEntityMapper: PostEntityMapper,
    private val userEntityMapper: UserEntityMapper
) : DataRepository {

    override fun retrieveDataFromServer(): Completable {
        return Observable.zip(
            apiClient.getUsers(),
            apiClient.getComments(),
            apiClient.getPost(),
            Function3<List<UserApiModel>, List<CommentApiModel>, List<PostApiModel>, Unit> { users, comments, posts ->
                database.commentDao()
                    .insertAll(comments.map { commentApiModelMapper.tranformTo(it) })
                database.postDao().insertAll(posts.map { postApiModelMapper.tranformTo(it) })
                database.userDao().insertAll(users.map { userApiModelMapper.tranformTo(it) })
            }
        ).ignoreElements()
    }


    override fun getAllPost(): Observable<List<Post>> = database.postDao().getAll().map {
        it.map { postEntity -> postEntityMapper.tranformTo(postEntity) }
    }

    override fun getPost(postId: Int): Observable<Post> {
        return  database.postDao().getPostById(postId).map { postEntity -> postEntityMapper.tranformTo(postEntity)}
    }

    override fun getCommentsByPostId(postId: Int): Observable<List<Comment>> {
        return  database.commentDao().findCommentsByPostId(postId).map { it.map {commentEntity -> commentEntityMapper.tranformTo(commentEntity) }}
    }

    override fun getUserById(userId: Int): Observable<User> {
        return database.userDao().getUserById(userId).map { userEntity -> userEntityMapper.tranformTo(userEntity) }
    }

    override fun updatePost(post: Post): Completable {
        return Completable.fromAction { database.postDao().upadate( postEntityMapper.transformFrom(post)) }
    }

    override fun cleanDatabase(): Completable {
        return Completable.fromAction { database.clearAllTables() }
    }
}