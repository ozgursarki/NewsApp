package com.ozgursarki.newsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherFragmentViewModel@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val weatherNews = MutableLiveData<ArrayList<Article>>()

    fun getWeather(){
        viewModelScope.launch {
            val weather = repository.getNews("weather")
            weatherNews.value = weather.articles
        }
    }

    fun getNews(language: LangType){
        viewModelScope.launch {
            val countryNews = repository.getNewsByLanguage(language.language,"weather")
            weatherNews.value = countryNews.articles
        }
    }
}