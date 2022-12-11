package com.example.androidprhome.presentation.adapter.User

interface ItemsUser {
    fun onClick()

    fun onElementSelected(name: String, about: String, imageView:Int,imageView2: Int)
}