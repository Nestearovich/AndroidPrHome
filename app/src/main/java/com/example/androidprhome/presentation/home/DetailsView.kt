package com.example.androidprhome.presentation.home

interface DetailsView {
    fun userLoggedOut()

    fun disolayItemData(name: String, date: String, imageView: Int)
}