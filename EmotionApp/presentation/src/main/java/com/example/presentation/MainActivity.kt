package com.example.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.presentation.databinding.ActivityMainBinding
import com.example.presentation.viewmodel.EmotionViewModel
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    private val viewModel by viewModels<EmotionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initObserve()
    }

    private fun initView() {
        binding.viewCallback = viewCallback
    }

    private fun initObserve() {
        repeatOn(Lifecycle.State.STARTED) {
            viewModel.emotionData.collect{
                Log.e(TAG, "data = $it")
                binding.emotionData = it
            }
        }
    }

    interface ViewCallback {
        fun onClick(view: View)
    }

    private val viewCallback = object : ViewCallback {
        override fun onClick(view: View) {
            when(view.id) {
                R.id.btn_emotion_recognition -> {
                    viewModel.getEmotionData(binding.edTxInput.text.toString())
                }
            }
        }
    }
}

fun LifecycleOwner.repeatOn(state: Lifecycle.State, block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(state, block)
    }
}