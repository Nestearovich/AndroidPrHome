package com.example.androidprhome.domain

import com.example.androidprhome.model.ItemsModel

class ItemsInteractor(private val itemsRepository: ItemsRepository) {
    fun getAbout():List<ItemsModel> {
        return itemsRepository.getAbout()
    }
}