package com.example.androidprhome.domain.items

import com.example.androidprhome.model.ItemsModel

interface ItemsRepository {

    suspend  fun getData()


    suspend fun showData(): List<ItemsModel>

}