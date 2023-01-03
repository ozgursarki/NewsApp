package com.ozgursarki.newsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozgursarki.newsapp.data.Repository
import com.ozgursarki.newsapp.model.everything.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScienceFragmentViewModel@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val scienceNews = MutableLiveData<ArrayList<Article>>()

    fun getScience(){
        viewModelScope.launch {
            val science = repository.getNews("science")
            scienceNews.value = science.articles
        }

    }
}