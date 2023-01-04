package com.ozgursarki.newsapp.data

import com.ozgursarki.newsapp.data.local.NewsDatabase
import com.ozgursarki.newsapp.data.local.entity.EntityArticle
import com.ozgursarki.newsapp.data.service.NewsAPI
import com.ozgursarki.newsapp.model.News
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val api: NewsAPI,
    private val db : NewsDatabase
) : Repository {
    override suspend fun getNews(category: String): News {
        return api.getNews(category)
    }

    override suspend fun getNewsByLanguage(country:String, category:String): News {
        return api.getNewsByLanguage(country,category)
    }

    override suspend fun upsert(entityArticle: EntityArticle) = db.newsDao().upsert(entityArticle)

    override suspend fun getSavedNews() : List<EntityArticle> {
        val articles = db.newsDao().getAllArticles()
        return articles
    }
}