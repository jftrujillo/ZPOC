package com.example.zpoc.di.module

import com.example.zpoc.Constants
import com.example.zpoc.data.datasource.remote.ApiClient
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteDataSourceModule {

    @Provides
    @Reusable
    fun getApiClient(): ApiClient {
        return retrofit2.Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build().create(ApiClient::class.java)
    }
}