package com.example.newzu.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newzu.data.NewsRepository
import com.example.newzu.models.News
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(val repo: NewsRepository): ViewModel() {

    private val _news = MutableLiveData<List<News>>()

    val news: LiveData<List<News>> = _news

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            _news.postValue(repo.getTopHeadlines())
        }
    }
}