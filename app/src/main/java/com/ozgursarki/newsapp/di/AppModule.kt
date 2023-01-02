package com.ozgursarki.newsapp.di

import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.data.RepositoryImplementation
import com.ozgursarki.newsapp.data.service.NewsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun getRepository(api: NewsAPI): Repository  {
        return RepositoryImplementation(api)
    }


}