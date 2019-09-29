package com.example.zpoc.di.module

import com.example.zpoc.presentation.home.HomeActivityMVP
import com.example.zpoc.presentation.home.mvp.HomeModel
import com.example.zpoc.presentation.home.mvp.HomePresenter
import dagger.Binds
import dagger.Module

@Module
abstract class HomeActivityModule {

    @Binds
    abstract fun provideHomePresenter(homePresenter: HomePresenter) : HomeActivityMVP.Presenter

    @Binds
    abstract fun provideHomeModel(homeModel: HomeModel):  HomeActivityMVP.Model
}