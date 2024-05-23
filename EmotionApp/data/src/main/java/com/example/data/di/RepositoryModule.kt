package com.example.data.di

import com.example.data.repository.EmotionRepositoryImpl
import com.example.domain.repository.EmotionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindEmotionRepository(
        repo: EmotionRepositoryImpl
    ): EmotionRepository
}