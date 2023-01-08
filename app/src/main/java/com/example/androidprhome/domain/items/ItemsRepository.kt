package com.example.androidprhome.domain.items

import com.example.androidprhome.model.ItemsModel

interface ItemsRepository {


    fun getAbout(): List<ItemsModel>
}