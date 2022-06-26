package com.example.api.services

import com.example.api.models.TopNewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
//        @Query("country") country: String
    ) : Response<TopNewsResponse>

}