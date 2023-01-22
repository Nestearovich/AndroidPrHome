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

    fun setView(itemsFragment: ItemsFragment) {
        itemsView = itemsFragment
    }

    fun getItems() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    val listItems = itemsInteractor.getData()
                    itemsView.dataReceived(listItems)
                }
            } catch (e: Exception) {
                Log.w("exception", "list items FAILED")
            }
        }
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.click)
    }

    fun elementSelected(
        id: Int,
        name: String,
        userName: String,
        email: String,
        street: String,
        suite: String,
        city: String,
        zipcode: String,
        lat: String,
        lng: String,
        phone: String,
        website: String,
        companyName: String,
        catchPhrase: String,
        bs: String,
    ) {
        itemsView.itemClicked(
            NavigateWithBundle(
                id,
                name,
                userName,
                email,
                street,
                suite,
                city,
                zipcode,
                lat,
                lng,
                phone,
                website,
                companyName,
                catchPhrase,
                bs,
            ),
            R.id.action_itemsFragment_to_detailsFragment
        )
    }
}

data class NavigateWithBundle(
   val id: Int,
   val name: String,
   val userName: String,
   val email: String,
   val street: String,
   val suite: String,
   val city: String,
   val zipcode: String,
   val lat: String,
   val lng: String,
   val phone: String,
   val website: String,
   val companyName: String,
   val catchPhrase: String,
   val bs: String,
)