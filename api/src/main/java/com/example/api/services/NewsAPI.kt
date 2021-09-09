package com.example.api.services

import com.example.api.module.TopNewsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines?country=in")
    fun getTopHeadlinesIndia() : Call<TopNewsResponse>

    @GET("top-headlines?country=us")
    fun getTopHeadlinesUS(): Call<TopNewsResponse>
}