package com.example.newzu.di

import android.content.Context
import com.example.newzu.services.NewsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.requestly.android.okhttp.api.RQCollector
import io.requestly.android.okhttp.api.RQInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val API_KEY = "37b269514ab74f81b6d27b686ffec935"
    private const val BASE_URL = "https://newsapi.org/v2/"

    @Provides
    @Singleton
    fun providesInterceptorToHttp() =
        Interceptor { chain ->
            val url = chain.request()
                .url.newBuilder()
                .addQueryParameter("country", "in")
                .addQueryParameter("apiKey", API_KEY)
                .build()

            val request = chain.request()
                .newBuilder().url(url)
                .build()

            return@Interceptor chain.proceed(request)
        }

    @Provides
    @Singleton
    fun provideHttp(@ApplicationContext appContext: Context, interceptor: Interceptor): OkHttpClient {

        val collector = RQCollector(context=appContext)
        val rqInterceptor = RQInterceptor.Builder(appContext).collector(collector).build()
        return OkHttpClient.Builder()

            .addInterceptor(interceptor)
            .addInterceptor(rqInterceptor)
            .connectTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsAPI =
        retrofit.create(NewsAPI::class.java)

}