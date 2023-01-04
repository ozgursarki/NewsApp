package com.ozgursarki.newsapp.data.local

import com.ozgursarki.newsapp.data.local.entity.EntityArticle
import com.ozgursarki.newsapp.model.everything.Article

fun Article.toDataArticle(): com.ozgursarki.newsapp.data.local.entity.EntityArticle{
    return com.ozgursarki.newsapp.data.local.entity.EntityArticle(
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = this.source,
        url = this.url,
        urlToImage = this.urlToImage,
        title = this.title
    )
}

fun EntityArticle.toModelArticle(): Article {
    return Article(
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = this.source,
        url = this.url,
        urlToImage = this.urlToImage,
        title = this.title
    )
}