package com.example.data.datasource

import android.util.Log
import com.example.data.model.EmotionRemote
import com.example.data.remote.service.ApiService
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmotionRemoteDataSourceImpl @Inject constructor(
    private val api: ApiService
): EmotionRemoteDataSource {
    companion object {
        private val TAG = this::class.java.simpleName
    }
    override fun fetchEmotionData(text: String): Single<EmotionRemote> {
        return api.fetchEmotionData(text)
    }

    override fun fetchEmotionDataWithCoroutine(text: String): Flow<EmotionRemote> = flow {
        api.fetchEmotionDataWithCoroutine(text)
            .suspendOnSuccess {
                emit(data)
            }.onError {
                Log.e(TAG, " onError = $errorBody")
            }.onException {
                Log.e(TAG," onException = ${exception.message}")
            }
    }
}