package com.example.androidprhome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprhome.model.ItemsModel

class ItemsViewModel: ViewModel() {
    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle>()
    val bundle: LiveData<NavigateWithBundle> = _bundle

    fun getAbout() {
        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.iavengers,
                "Avengers",
                "First",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 2",
                "Age Altron",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 3",
                "Infinity War",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 4",
                "End",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider,
                "Spider-man",
                "Homecoming",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider2,
                "Spider-man 2",
                "Far from home",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider,
                "Spider-man 3",
                "No way home",
                R.drawable.star
            ),
        )
        _items.value = listItems
    }

    fun imageViewClicked() {
        _msg.value = "ImageView clicked"

        fun elementClicked(name: String, about: String, imageView: Int, imageView2: Int) {
            _bundle.value = NavigateWithBundle(
                image = imageView,
                name = name,
                about = about,
                imageView2 = imageView2
            )


        }
    }
}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val about: String,
    val imageView2: Int
)