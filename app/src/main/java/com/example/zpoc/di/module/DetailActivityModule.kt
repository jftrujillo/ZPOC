package com.example.zpoc.di.module

import com.example.zpoc.presentation.detail.DetailActivityMVP
import com.example.zpoc.presentation.detail.mvp.DetailModel
import com.example.zpoc.presentation.detail.mvp.DetailPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class DetailActivityModule {

    @Binds
    abstract fun provideDetailPresenter(detailPresenter: DetailPresenter): DetailActivityMVP.Presenter

    @Binds
    abstract fun provideDetailModel(detailModel: DetailModel): DetailActivityMVP.Model
}