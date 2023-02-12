package com.example.androidprhome.di

import android.content.Context
import com.example.androidprhome.data.database.dao.ItemsDAO
import com.example.androidprhome.data.database.dao.ItemsDataBase
import dagger.Module
import dagger.Provides


@Module

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