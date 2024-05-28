package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetEmotionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmotionViewModel @Inject constructor(
    private val getEmotionUseCase: GetEmotionUseCase
): ViewModel() {
    companion object {
        private val TAG = this::class.java.simpleName
    }

    fun test() {
        val text = "즐거워!"
        viewModelScope.launch {
            getEmotionUseCase.invokeWithCoroutine(text)
                .flowOn(Dispatchers.IO)
                .collect{
                    Log.e(TAG, "emotion : ${it.emotionData}")
                }
        }
    }
}