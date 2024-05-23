package com.example.data.datasource

import com.example.data.model.EmotionRemote
import com.example.data.remote.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService
): EmotionRemoteDataSource {
    override suspend fun fetchEmotionData(): Flow<EmotionRemote> {
        return api.fetchEmotionData()
    }
}