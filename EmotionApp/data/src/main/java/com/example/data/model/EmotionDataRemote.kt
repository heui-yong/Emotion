package com.example.data.model

import com.example.domain.model.EmotionData
import com.google.gson.annotations.SerializedName

data class EmotionDataRemote(
    @SerializedName("inputText")
    val inputText: String,
    @SerializedName("outputText")
    val outputText: String
)

internal fun EmotionDataRemote.toDomain() = EmotionData(
    inputText = inputText,
    outputText = outputText
)
