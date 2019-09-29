package com.example.zpoc.domain.usecases

import com.example.zpoc.data.DataRepository
import io.reactivex.Completable
import javax.inject.Inject


class SyncDataUseCase @Inject constructor(
    private val dataRepository: DataRepository)
{

    operator fun invoke(): Completable {
        return dataRepository.retrieveDataFromServer()
    }
}