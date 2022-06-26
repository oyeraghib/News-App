package com.example.newzu.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newzu.data.NewsRepository
import com.example.newzu.models.News
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repo = NewsRepository()

    private val _news = MutableLiveData<List<News>>()

    val news: LiveData<List<News>> = _news

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _news.postValue(repo.getTopHeadlines())
        }
    }

}