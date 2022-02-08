package com.example.hiltmvvm.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

//    @Provides
//    fun provideContext(context: Context): Application {
//        return context.applicationContext as Application
//    }


}