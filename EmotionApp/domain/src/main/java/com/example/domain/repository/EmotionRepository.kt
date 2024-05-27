package com.example.domain.repository

import com.example.domain.model.Emotion
import io.reactivex.Flowable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface EmotionRepository {
    fun getRemoteEmotion(
        text: String
    ): Single<Emotion>
}