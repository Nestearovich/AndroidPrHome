package com.example.androidprhome.di

import com.example.androidprhome.domain.items.ItemsInteractor
import com.example.androidprhome.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class DomainModule {

    @Provides
    fun provideItemsInteractor(
        itemsRepository: ItemsRepository
    ): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }
}