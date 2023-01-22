package com.example.androidprhome.domain.items

import com.example.androidprhome.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
) {
    suspend fun getData():List<ItemsModel> {
        return itemsRepository.getData()
    }
}