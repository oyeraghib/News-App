package com.example.api

import com.example.api.services.NewsAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NewsAPIClient {

    const val API_KEY = "37b269514ab74f81b6d27b686ffec935"
    const val BASE_URL = "https://newsapi.org/v2/"

    val interceptor = Interceptor { chain ->
    val url = chain.request()
        .url()
        .newBuilder()
        .addQueryParameter("apiKey", API_KEY)
        .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)

    }

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(2, TimeUnit.MINUTES)
        .build()


    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())

    val api = retrofit
        .build()
        .create(NewsAPI::class.java)
}