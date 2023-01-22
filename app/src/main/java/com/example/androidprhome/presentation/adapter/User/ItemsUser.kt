package com.example.androidprhome.presentation.adapter.User

interface ItemsUser {
    fun onClick()

    fun onElementSelected(
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
    )
}