package com.example.domain.usecase

import com.example.domain.model.Emotion
import com.example.domain.repository.EmotionRepository
import kotlinx.coroutines.flow.Flow

class GetEmotionUseCase constructor(private val repository: EmotionRepository) {
    suspend fun invoke(): Flow<Emotion> = repository.getRemoteEmotion()
}