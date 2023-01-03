package com.ozgursarki.newsapp.data

import com.ozgursarki.newsapp.model.News
import com.ozgursarki.newsapp.model.everything.GetNews
import retrofit2.http.Query

interface Repository {

    suspend fun getNews(@Query("q", encoded = true) category: String) : News

    suspend fun getNewsByLanguage(country:String,category: String): News
}