package com.ozgursarki.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ozgursarki.newsapp.data.local.entity.EntityArticle

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun upsert(entityArticle: EntityArticle): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<EntityArticle>
}