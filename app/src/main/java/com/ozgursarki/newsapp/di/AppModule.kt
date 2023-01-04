package com.ozgursarki.newsapp.di

import android.content.Context
import androidx.room.Database
import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.data.RepositoryImplementation
import com.ozgursarki.newsapp.data.local.NewsDatabase
import com.ozgursarki.newsapp.data.service.NewsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRetrofit(): NewsAPI{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        return NewsDatabase(context)
    }

    @Provides
    @Singleton
    fun getRepository(api: NewsAPI, db:NewsDatabase): Repository  {
        return RepositoryImplementation(api,db)
    }


}