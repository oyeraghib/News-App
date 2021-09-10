package com.example.api.services

import com.example.api.models.TopNewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("top-headlines?country=in")
    suspend fun getTopHeadlinesIndia() : Response<TopNewsResponse>

    @GET("top-headlines?country=us")
    suspend fun getTopHeadlinesUS(): Response<TopNewsResponse>
}