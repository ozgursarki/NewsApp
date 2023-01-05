package com.ozgursarki.newsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.data.local.entity.EntityArticle
import com.ozgursarki.newsapp.data.local.toModelArticle
import com.ozgursarki.newsapp.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveFragmentViewModel@Inject constructor(
    private val repository : Repository
) : ViewModel() {

    val savedNews = MutableLiveData<ArrayList<Article>>()

    fun getSavedNews(){
        val list = arrayListOf<Article>()
        viewModelScope.launch {
            val articles = repository.getSavedNews()
            articles.forEach {
                list.add(it.toModelArticle())
            }
            savedNews.value = list
        }
    }

    fun deleteArticle(article: EntityArticle){
        viewModelScope.launch {
            repository.deleteArticle(article)
        }
    }
}