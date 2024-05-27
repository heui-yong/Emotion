package com.example.data.model

import com.example.domain.model.Emotion
import com.google.gson.annotations.SerializedName

data class EmotionRemote(
    @SerializedName("emotionData")
    val emotionData: EmotionDataRemote,
    @SerializedName("status")
    val status: Int
)

internal fun EmotionRemote.toDomain() = Emotion(
    emotionData = emotionData.toDomain(),
    status = status
)
