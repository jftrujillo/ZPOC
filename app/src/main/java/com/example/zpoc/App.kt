package com.example.zpoc

import android.app.Application
import com.example.zpoc.di.component.AppComponent
import com.example.zpoc.di.component.DaggerAppComponent
import com.example.zpoc.di.module.ApplicationModule

class App: Application() {

    companion object {
        lateinit var instance: App private set
    }

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    fun setup () {
        component = DaggerAppComponent.builder().applicationModule((ApplicationModule(this))).build()
        component.inject(this)
    }

    fun getApplicationGetComponent(): AppComponent {
        return component
    }
}