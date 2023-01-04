package com.ozgursarki.newsapp.data

import com.ozgursarki.newsapp.data.local.entity.EntityArticle
import com.ozgursarki.newsapp.model.News
import retrofit2.http.Query

interface Repository {

    suspend fun getNews(@Query("q", encoded = true) category: String) : News

    suspend fun getNewsByLanguage(country:String,category: String): News

    suspend fun upsert(entityArticle: EntityArticle) : Long

    suspend fun getSavedNews() : List<EntityArticle>

}