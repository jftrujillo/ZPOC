package com.example.zpoc.di.component

import android.app.Application
import com.example.zpoc.di.module.*
import com.example.zpoc.presentation.detail.DetailActivity
import com.example.zpoc.presentation.home.HomeActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    ApplicationModule::class,
    RemoteDataSourceModule::class,
    CacheDataSourceModule::class,
    RepositoryDataModule::class,
    HomeActivityModule::class,
    DetailActivityModule::class])

interface AppComponent {
    fun inject(application: Application)
    fun inject(homeActivity: HomeActivity)
    fun inject(detailActivity: DetailActivity)
}