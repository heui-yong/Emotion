package com.example.data.datasource

import com.example.data.model.EmotionRemote
import com.example.data.remote.service.ApiService
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService
): EmotionRemoteDataSource {
    override fun fetchEmotionData(text: String): Single<EmotionRemote> {
        return api.fetchEmotionData(text)
    }
}