package com.example.newzu.data

import com.example.api.NewsAPIClient
import com.example.api.models.News

class NewsRepository {

    val api = NewsAPIClient.api

    suspend fun getTopHeadlines(): List<News>? {

        val response = api.getTopHeadlinesIndia()
        return response.body()?.articles
    }
}