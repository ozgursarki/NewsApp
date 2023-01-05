package com.ozgursarki.newsapp.data.local

import androidx.room.*
import com.ozgursarki.newsapp.data.local.entity.EntityArticle

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(entityArticle: EntityArticle): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<EntityArticle>

    @Delete
    suspend fun deleteArticle(article: EntityArticle)


}