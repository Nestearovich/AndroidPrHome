package com.example.androidprhome.domain.items

import com.example.androidprhome.model.FavoritesModel
import com.example.androidprhome.model.ItemsModel

interface ItemsRepository {

    suspend  fun getData()
    suspend fun showData(): List<ItemsModel>

    suspend fun findItemByDescription(searchText:String):ItemsModel
    suspend fun favClicked(itemsModel: ItemsModel)

    suspend fun getFavorites(): List<FavoritesModel>

}