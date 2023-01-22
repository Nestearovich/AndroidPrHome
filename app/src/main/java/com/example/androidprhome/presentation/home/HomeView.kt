package com.example.androidprhome.presentation.home

import com.example.androidprhome.model.UserModel

interface HomeView {
    fun showUserCreds(login: UserModel)

    fun goToDisplay(destination: Int)
}