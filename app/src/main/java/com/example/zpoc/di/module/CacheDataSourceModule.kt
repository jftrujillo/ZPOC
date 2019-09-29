package com.example.zpoc.di.module

import android.content.Context
import androidx.room.Room
import com.example.zpoc.data.datasource.cache.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class CacheDataSourceModule {

    @Provides
    @Reusable
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "post.db"
        ).build()
    }
}