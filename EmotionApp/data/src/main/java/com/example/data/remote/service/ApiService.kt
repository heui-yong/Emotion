package com.example.data.remote.service

import com.example.data.model.EmotionRemote
import com.skydoves.sandwich.ApiResponse
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("/emotion")
    fun fetchEmotionData(
        @Query("text") text: String,
    ): Single<EmotionRemote>
    @POST("/emotion")
    suspend fun fetchEmotionDataWithCoroutine(
        @Query("text") text: String,
    ): ApiResponse<EmotionRemote>
}