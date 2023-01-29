package com.example.androidprhome.domain.items

import com.example.androidprhome.model.FavoritesModel
import com.example.androidprhome.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
) {
    suspend fun getData() {
        itemsRepository.getData()
    }

    suspend fun showData(): List<ItemsModel>{
        return itemsRepository.showData()
    }

    suspend fun onFavClicked(description: String){
        val foundItem =  itemsRepository.findItemByDescription(description)
        itemsRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): List<FavoritesModel>{
        return itemsRepository.getFavorites()
    }
}