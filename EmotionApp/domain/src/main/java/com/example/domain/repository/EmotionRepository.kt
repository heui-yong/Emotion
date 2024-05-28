package com.example.domain.repository

import com.example.domain.model.Emotion
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface EmotionRepository {
    fun getRemoteEmotion(
        text: String
    ): Single<Emotion>

    fun getRemoteEmotionWithCoroutine(
        text: String
    ): Flow<Emotion>
}