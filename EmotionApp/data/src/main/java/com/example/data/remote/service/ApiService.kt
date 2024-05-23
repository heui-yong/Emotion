package com.example.data.remote.service

import com.example.data.model.EmotionRemote
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface ApiService {

    @POST("/test")
    suspend fun fetchEmotionData(): Flow<EmotionRemote>
}