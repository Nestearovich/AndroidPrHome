package com.example.androidprhome.di

import android.content.Context
import com.example.androidprhome.data.database.dao.ItemsDAO
import com.example.androidprhome.data.database.dao.ItemsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {


    @Provides
    fun provideItemsDao(itemsDataBase: ItemsDataBase): ItemsDAO {
        return itemsDataBase.getItemsDao()
    }

    @Provides
    fun itemsDatabase(context: Context): ItemsDataBase{
        return ItemsDataBase.getItemsDatabaseInstance(context)
    }
}