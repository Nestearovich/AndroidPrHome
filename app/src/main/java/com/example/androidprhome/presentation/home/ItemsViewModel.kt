package com.example.androidprhome.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprhome.R
import com.example.androidprhome.domain.ItemsInteractor
import com.example.androidprhome.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsInteractor: ItemsInteractor,
) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        val listItems = itemsInteractor.getData()
        _items.value = listItems
    }

    fun imageViewClicked() {
        _msg.value = R.string.click
    }

    fun elementClicked(name: String, about: String,  imageView: Int, imageView2: Int) {
        _bundle.value = NavigateWithBundle(
            name = name,
            about = about,
            image = imageView,
            image2 = imageView2
        )
    }

    fun userNavigated() {
        _bundle.value = null
    }
}

data class NavigateWithBundle(
    val name: String,
    val about: String,
    val image: Int,
    val image2: Int,
)