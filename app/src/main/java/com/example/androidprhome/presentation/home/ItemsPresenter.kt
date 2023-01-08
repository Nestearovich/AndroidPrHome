package com.example.androidprhome.presentation.home

import com.example.androidprhome.domain.items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

   private lateinit var itemsView: ItemsView


    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }
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

data class NavigateWithBundle(
    val image: Int,
    val image2: Int,
    val name: String,
    val date: String
)