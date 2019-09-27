package com.example.zpoc.di.component

import android.app.Application
import com.example.zpoc.di.module.ApplicationModule
import dagger.Component


@Component (modules = [ApplicationModule::class])
interface AppComponent {
    fun inject(application: Application)
}