package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import io.reactivex.Completable
import javax.inject.Inject


class DeleteAllPostUseCase @Inject constructor(val repository: DataRepository) {

    operator fun invoke() : Completable {
        return repository.cleanDatabase()
    }
}