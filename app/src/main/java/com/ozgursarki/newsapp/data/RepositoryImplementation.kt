package com.ozgursarki.newsapp.data

import com.ozgursarki.newsapp.model.everything.GetNews
import com.ozgursarki.newsapp.data.service.NewsAPI
import com.ozgursarki.newsapp.model.News
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val api: NewsAPI
) : Repository {
    override suspend fun getNews(category: String): News {
        return api.getNews(category)
    }
}