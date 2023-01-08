package com.example.androidprhome.presentation.view

import com.example.androidprhome.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
        val doesUserExist = authInteractor.checkUserExists()
        mainView.userExistsResult(doesUserExist)

    }
}