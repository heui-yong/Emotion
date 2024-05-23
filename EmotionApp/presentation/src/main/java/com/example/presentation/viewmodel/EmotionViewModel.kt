package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetEmotionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmotionViewModel @Inject constructor(
    private val getEmotionUseCase: GetEmotionUseCase
): ViewModel() {

    fun test() {
        viewModelScope.launch {
            getEmotionUseCase.invoke().flowOn(Dispatchers.IO)
                .catch { e ->
                    // handle exception
                    Log.e("TAG", e.toString())
                }
                .collect {
                    // list of users from the network
                    Log.e("TAG", it.data)
                }
        }
    }
}