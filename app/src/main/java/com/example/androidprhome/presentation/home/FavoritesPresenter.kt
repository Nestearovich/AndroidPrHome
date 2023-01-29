package com.example.androidprhome.presentation.home

import android.util.Log
import com.example.androidprhome.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(
    private val itemsInteractor: ItemsInteractor
) {
private lateinit var favoritesView: FavoritesView



  suspend  fun getFavorites(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val favoritesItems = itemsInteractor.getFavorites()
                favoritesView.getFavorites(favoritesItems)
            }catch (e:java.lang.Exception){
                Log.w("fav error",e.toString())
            }
        }
    }
}