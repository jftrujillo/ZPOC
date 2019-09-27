package com.example.zpoc.di.component

import android.app.Application
import com.example.zpoc.di.module.ApplicationModule
import com.example.zpoc.di.module.RemoteDataSourceModule
import com.example.zpoc.presentation.home.HomeActivity
import dagger.Component


@Component (modules = [ApplicationModule::class, RemoteDataSourceModule::class])
interface AppComponent {
    fun inject(application: Application)
    fun inject(homeActivity: HomeActivity)
}