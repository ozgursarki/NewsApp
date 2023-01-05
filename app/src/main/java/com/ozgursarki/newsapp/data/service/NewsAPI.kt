package com.ozgursarki.newsapp.data.service

import com.ozgursarki.newsapp.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("q", encoded = true)
        category: String,
        @Query("apiKey", encoded = true)
        apikey: String = "898f01ecfd324d6f9f7f91eb7a62b4af"
    ): News

    @GET("top-headlines")
    suspend fun getNewsByLanguage(
        @Query("country", encoded = true)
        country: String,
        @Query("q", encoded = true)
        category: String,
        @Query("apiKey", encoded = true)
        apikey: String = "898f01ecfd324d6f9f7f91eb7a62b4af"
    ): News
}