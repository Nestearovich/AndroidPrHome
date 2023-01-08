package com.example.androidprhome.presentation.auths

import javax.inject.Inject

class DisplayPresenter @Inject constructor() {

    private lateinit var displayView: DisplayView
    fun setView(displayFragment: DisplayFragment){
        displayView = displayFragment
    }

    fun goToItemsFragment(){
        displayView.goToItemsFragment()
    }
}