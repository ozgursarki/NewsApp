package com.ozgursarki.newsapp.data.service

import com.ozgursarki.newsapp.model.News
import com.ozgursarki.newsapp.model.everything.GetNews
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("q", encoded = true)
        category: String,
        @Query("apiKey", encoded = true)
        apikey: String = "e24d56de324d4f3e8ab373399a6878ef"
    ): News

    @GET("top-headlines")
    suspend fun getNewsByLanguage(
        @Query("country", encoded = true)
        country: String,
        @Query("q", encoded = true)
        category: String,
        @Query("apiKey", encoded = true)
        apikey: String = "e24d56de324d4f3e8ab373399a6878ef"
    ): News
}