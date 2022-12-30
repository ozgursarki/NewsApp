package com.ozgursarki.newsapp.model.everything

data class Sport(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)