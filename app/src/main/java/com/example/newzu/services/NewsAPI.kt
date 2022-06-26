package com.example.newzu.services

import com.example.newzu.models.TopNewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
    ): Response<TopNewsResponse>

}