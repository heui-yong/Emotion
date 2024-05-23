package com.example.data.datasource

import com.example.data.model.EmotionRemote
import kotlinx.coroutines.flow.Flow

interface EmotionRemoteDataSource {
    suspend fun fetchEmotionData(): Flow<EmotionRemote>
}