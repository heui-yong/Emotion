package com.example.data.repository

import android.util.Log
import com.example.data.datasource.EmotionRemoteDataSource
import com.example.data.model.toDomain
import com.example.domain.model.Emotion
import com.example.domain.repository.EmotionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRepositoryImpl @Inject constructor(
    private val remoteDataSource: EmotionRemoteDataSource
): EmotionRepository {
    override suspend fun getRemoteEmotion(): Flow<Emotion> {
        return flow {
            remoteDataSource.fetchEmotionData().collect{
                Log.e("TAG","remoteDataSource.fetchEmotionData().collect : $it")
                emit(it.toDomain())
            }
        }
    }

}