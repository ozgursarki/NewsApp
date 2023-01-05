package com.ozgursarki.newsapp.data.local

import com.ozgursarki.newsapp.data.local.entity.EntityArticle
import com.ozgursarki.newsapp.model.Article

fun Article.toDataArticle(): EntityArticle{
    return EntityArticle(
        uid = this.id,
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
        id = this.uid,
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