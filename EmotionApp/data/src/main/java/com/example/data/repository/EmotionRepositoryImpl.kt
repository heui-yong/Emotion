package com.example.data.repository

import com.example.data.datasource.EmotionRemoteDataSource
import com.example.data.model.toDomain
import com.example.domain.model.Emotion
import com.example.domain.repository.EmotionRepository
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRepositoryImpl @Inject constructor(
    private val remoteDataSource: EmotionRemoteDataSource
): EmotionRepository {
    override fun getRemoteEmotion(
        text: String
    ): Single<Emotion> {
        return remoteDataSource.fetchEmotionData(text).flatMap {
            Single.just(it.toDomain())
        }
    }

    override fun getRemoteEmotionWithCoroutine(text: String): Flow<Emotion> = flow {
        remoteDataSource.fetchEmotionDataWithCoroutine(text).collect{
            emit(it.toDomain())
        }
    }
}