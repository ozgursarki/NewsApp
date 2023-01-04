package com.ozgursarki.newsapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ozgursarki.newsapp.model.everything.Source

@Entity(
    tableName = "articles"
)
data class EntityArticle(
    @PrimaryKey (autoGenerate = true)
    val uid: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)
