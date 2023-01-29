package com.example.androidprhome.presentation.home

import com.example.androidprhome.model.FavoritesModel

interface FavoritesView {

suspend fun getFavorites(favoritesItems: List<FavoritesModel>)
}