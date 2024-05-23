package com.example.data.di

import com.example.domain.repository.EmotionRepository
import com.example.domain.usecase.GetEmotionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Provides
    fun providesGetEmotionUseCase(
        repo: EmotionRepository
    ): GetEmotionUseCase {
        return GetEmotionUseCase(repo)
    }
}