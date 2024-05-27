package com.example.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetEmotionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class EmotionViewModel @Inject constructor(
    private val getEmotionUseCase: GetEmotionUseCase
): ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    fun test() {
        val text = "즐거워!"
        val disposable = getEmotionUseCase.invoke(text)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { error ->
                Log.e("TAG", "error : ${error.message}")
            }
            .subscribe({ emotionData ->
                Log.e("TAG", "data = ${emotionData.emotionData}")
                // 여기에서 emotionData를 사용할 수 있습니다.
            }, {})

        compositeDisposable.add(disposable)
    }
}