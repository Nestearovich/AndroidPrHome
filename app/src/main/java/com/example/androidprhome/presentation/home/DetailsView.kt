package com.example.androidprhome.presentation.home

interface DetailsView {
    fun userLoggedOut(destination: Int)

    fun displayItemData(
        name: String,
        username: String,
        email: String,
        phone: String
    )
}