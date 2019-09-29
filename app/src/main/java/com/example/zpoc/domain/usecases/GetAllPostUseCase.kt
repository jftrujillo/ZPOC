package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import com.example.zpoc.domain.model.Post
import io.reactivex.Observable
import javax.inject.Inject

class GetAllPostUseCase @Inject constructor(private val dataRepository: DataRepository) {
    operator fun invoke(): Observable<List<Post>> {
        return dataRepository.getAllPost()
    }
}