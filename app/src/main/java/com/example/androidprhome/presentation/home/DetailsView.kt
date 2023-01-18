package com.example.androidprhome.presentation.home

interface DetailsView {
    fun userLoggedOut(destination: Int)

    fun displayItemData(name: String, date: String, imageView: Int)
}