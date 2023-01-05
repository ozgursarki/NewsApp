package com.ozgursarki.newsapp.model

data class News(
    val status: String,
    val totalResults: Int,
    val articles : ArrayList<Article>
)
