package com.example.androidprhome.domain

import com.example.androidprhome.model.ItemsModel

interface ItemsRepository {


    fun getAbout(): List<ItemsModel>
}