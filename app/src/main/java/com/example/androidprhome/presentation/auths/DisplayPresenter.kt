package com.example.androidprhome.presentation.auths

import com.example.androidprhome.R
import javax.inject.Inject

class DisplayPresenter @Inject constructor() {

    private lateinit var displayView: DisplayView
    fun setView(displayFragment: DisplayFragment){
        displayView = displayFragment
    }

    fun goToItemsFragment(){
        displayView.goToItemsFragment(R.id.action_displayFragment_to_itemsFragment)
    }
}