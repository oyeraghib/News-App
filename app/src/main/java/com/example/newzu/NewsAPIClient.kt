package com.example.newzu

import com.example.newzu.services.NewsAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NewsAPIClient {

    private const val API_KEY = "37b269514ab74f81b6d27b686ffec935"
    private const val BASE_URL = "https://newsapi.org/v2/"

    private val interceptor = Interceptor { chain ->
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("country", "in")
            .addQueryParameter("apiKey", API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()

        return@Interceptor chain.proceed(request)

    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(2, TimeUnit.MINUTES)
        .readTimeout(2, TimeUnit.MINUTES)
        .build()


    private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())

    val api: NewsAPI = retrofit
        .build()
        .create(NewsAPI::class.java)
}