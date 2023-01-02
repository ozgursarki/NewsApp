package com.ozgursarki.newsapp.model

import com.ozgursarki.newsapp.model.everything.Article

data class News(
    val status: String,
    val totalResults: Int,
    val articles : ArrayList<Article>
)
