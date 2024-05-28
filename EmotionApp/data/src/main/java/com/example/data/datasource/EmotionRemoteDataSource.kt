package com.example.data.datasource

import com.example.data.model.EmotionRemote
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface EmotionRemoteDataSource {
    fun fetchEmotionData(
        text: String
    ): Single<EmotionRemote>

    fun fetchEmotionDataWithCoroutine(
        text: String
    ): Flow<EmotionRemote>
}