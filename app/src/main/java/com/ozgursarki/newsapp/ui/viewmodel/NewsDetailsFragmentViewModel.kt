package com.ozgursarki.newsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.data.local.toDataArticle
import com.ozgursarki.newsapp.model.everything.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsDetailsFragmentViewModel@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    fun saveArticle(article: Article){
        viewModelScope.launch {
            repository.upsert(article.toDataArticle())
        }
    }
}