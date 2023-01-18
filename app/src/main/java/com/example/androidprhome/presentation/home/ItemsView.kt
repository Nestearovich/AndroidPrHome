package com.example.androidprhome.presentation.home

import com.example.androidprhome.model.ItemsModel

interface ItemsView {
    fun dataReceived(list:List<ItemsModel>)

    fun imageViewClicked(msg:Int)

    fun itemClicked(navigateWithBundle: NavigateWithBundle,destination: Int)
}