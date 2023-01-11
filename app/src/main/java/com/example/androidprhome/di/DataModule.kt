package com.example.androidprhome.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.androidprhome.data.auth.AuthRepositoryImpl
import com.example.androidprhome.data.items.ItemsRepositoryImpl
import com.example.androidprhome.data.sharedpreferences.SharedPreferencesHelper
import com.example.androidprhome.domain.items.ItemsRepository
import com.example.androidprhome.domain.auth.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl,
    ): AuthRepository

    companion object {
        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(
            @ApplicationContext context: Context,
        ): SharedPreferencesHelper {
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)
            )
        }
    }
}