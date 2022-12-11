package com.example.androidprhome.presentation.view

import com.example.androidprhome.domain.ItemsInteractor

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor
) {
    fun getAbout(){
        val listItems = itemsInteractor.getAbout()
        itemsView.dataReceived(listItems)
    }
    fun imageViewClicked(){
        itemsView.imageViewClicked()
    }
    fun elementSelected(name: String, about: String, imageView: Int, imageView2: Int){

        itemsView.goToDetails(name, about, imageView, imageView2)
    }
}