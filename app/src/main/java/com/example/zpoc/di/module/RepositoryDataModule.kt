package com.example.zpoc.di.module

import com.example.zpoc.data.DataRepository
import com.example.zpoc.data.DataRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryDataModule {

    @Binds
    abstract fun provideDataRepository(dataRepositoryImpl: DataRepositoryImpl) : DataRepository
}