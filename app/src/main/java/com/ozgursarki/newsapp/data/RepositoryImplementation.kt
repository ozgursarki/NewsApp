package com.ozgursarki.newsapp.data

import com.ozgursarki.newsapp.model.everything.GetNews
import com.ozgursarki.newsapp.service.NewsAPI
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val api: NewsAPI
) : Repository {
    override suspend fun getNews(category: String): GetNews {
        return api.getNews(category)
    }
}