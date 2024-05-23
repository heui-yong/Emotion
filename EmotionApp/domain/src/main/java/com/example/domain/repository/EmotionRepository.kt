package com.example.domain.repository

import com.example.domain.model.Emotion
import kotlinx.coroutines.flow.Flow

interface EmotionRepository {
    suspend fun getRemoteEmotion(): Flow<Emotion>
}