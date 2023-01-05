package com.ozgursarki.newsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozgursarki.newsapp.data.RepositoryImplementation
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportFragmentViewModel @Inject constructor(
    private val repositoryImpl: RepositoryImplementation
) : ViewModel() {

    val sports = MutableLiveData<ArrayList<Article>>()

    fun getSportNews(){
        viewModelScope.launch {
            val news = repositoryImpl.getNews("sport")
            sports.value = news.articles

        }
    }

    fun getNews(language: LangType){
        viewModelScope.launch {
            val countryNews = repositoryImpl.getNewsByLanguage(language.language,"sport")
            sports.value = countryNews.articles
        }
    }

    fun insertArticle(entityArticle:com.ozgursarki.newsapp.data.local.entity.EntityArticle){
        viewModelScope.launch {
            repositoryImpl.upsert(entityArticle)
        }
    }
}