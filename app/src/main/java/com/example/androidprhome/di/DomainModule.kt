package com.example.androidprhome.di

import com.example.androidprhome.domain.auth.AuthInteractor
import com.example.androidprhome.domain.auth.AuthRepository
import com.example.androidprhome.domain.items.ItemsInteractor
import com.example.androidprhome.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides

@Module


class DomainModule {

    @Provides
    fun provideItemsInteractor(
        itemsRepository: ItemsRepository
    ): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }
    @Provides
    fun provideAuthInteractor(
        authRepository: AuthRepository
    ): AuthInteractor {
        return AuthInteractor(authRepository)
    }
}