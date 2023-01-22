package com.example.androidprhome.di

import android.content.Context
import com.example.androidprhome.data.authitems.AuthRepositoryImpl
import com.example.androidprhome.data.authitems.ItemsRepositoryImpl
import com.example.androidprhome.data.service.ApiService
import com.example.androidprhome.data.sharedprefences.SharedPreferencesHelper
import com.example.androidprhome.domain.auth.AuthRepository
import com.example.androidprhome.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository(
        itemsRepositoryImpl: ItemsRepositoryImpl
    ): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    companion object{
        private const val SP_KEY = "SP_KEY"
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        @Provides
        fun provideSharedPrefences(
            @ApplicationContext context: Context
        ): SharedPreferencesHelper{
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE)
            )
        }
        @Provides
        fun provideApiService(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }
        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
