package com.example.androidprhome.presentation.view

import com.example.androidprhome.model.ItemsModel

interface ItemsView {
    fun dataReceived(list:List<ItemsModel>)

    fun imageViewClicked()

    fun goToDetails(name: String, about: String, imageView: Int, imageView2: Int)
}