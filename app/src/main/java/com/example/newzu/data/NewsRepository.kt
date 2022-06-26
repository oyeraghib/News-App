package com.example.newzu.data

import com.example.newzu.NewsAPIClient
import com.example.newzu.models.News

class NewsRepository {

    private val api = NewsAPIClient.api

    suspend fun getTopHeadlines(): List<News>? {

        val response = api.getTopHeadlines()
        return response.body()?.articles
    }
}