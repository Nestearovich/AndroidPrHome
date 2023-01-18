package com.example.androidprhome.presentation.home

import android.util.Log
import com.example.androidprhome.R
import com.example.androidprhome.domain.items.ItemsInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class ItemsPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {

   private lateinit var itemsView: ItemsView


    fun setView(itemsFragment: ItemsFragment){
        itemsView = itemsFragment
    }
    fun getItems() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler){
            try {

                val job = launch {
                    val listItems = itemsInteractor.getAbout()
                    itemsView.dataReceived(listItems)
                }
            }catch (e: Exception){
                Log.w("exception", "list items FAILED")
            }

        }
    }
    fun imageViewClicked(){
        itemsView.imageViewClicked(R.string.click)
    }
    fun elementSelected(name: String, about: String, imageView: Int, imageView2: Int){
        itemsView.itemClicked(NavigateWithBundle(imageView, imageView2, name, about), R.id.action_itemsFragment_to_detailsFragment)
    }
}

data class NavigateWithBundle(
    val image: Int,
    val image2: Int,
    val name: String,
    val about: String
)