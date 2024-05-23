package com.example.data.model

import com.example.domain.model.Emotion
import com.google.gson.annotations.SerializedName

data class EmotionRemote(
    @SerializedName("data")
    val data: String,
    @SerializedName("status")
    val status: Int
)

internal fun EmotionRemote.toDomain() = Emotion(
    data = data,
    status = status
)
