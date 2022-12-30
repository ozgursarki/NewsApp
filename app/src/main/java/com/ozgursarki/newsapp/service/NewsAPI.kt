package com.ozgursarki.newsapp.service

import com.ozgursarki.newsapp.model.everything.GetNews
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(@Query("q", encoded = true) category: String) :GetNews


}