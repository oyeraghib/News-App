package com.example.newzu.data

import com.example.newzu.models.News
import com.example.newzu.services.NewsAPI
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(private val api: NewsAPI) {

    suspend fun getTopHeadlines(): List<News>? {
        val resp = api.getTopHeadlines()
        return resp.body()?.articles
    }
}