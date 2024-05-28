package com.example.domain.usecase

import com.example.domain.model.Emotion
import com.example.domain.repository.EmotionRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

class GetEmotionUseCase(private val repository: EmotionRepository) {
    fun invoke(
        text: String
    ): Single<Emotion> = repository.getRemoteEmotion(text)

    fun invokeWithCoroutine(
        text: String
    ): Flow<Emotion> = repository.getRemoteEmotionWithCoroutine(text)
}