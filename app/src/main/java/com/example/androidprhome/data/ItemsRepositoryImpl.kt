package com.example.androidprhome.data

import com.example.androidprhome.R
import com.example.androidprhome.domain.ItemsRepository
import com.example.androidprhome.model.ItemsModel
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor() :ItemsRepository {

    override fun getAbout(): List<ItemsModel> {
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
        return listItems
    }
}
