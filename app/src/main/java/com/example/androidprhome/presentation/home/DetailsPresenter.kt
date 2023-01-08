package com.example.androidprhome.presentation.home

import com.example.androidprhome.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment){
        detailsView = detailsFragment
    }
    fun getArguments(name: String, about: String, imageView: Int, int: Int){
        detailsView.disolayItemData(
            when(name.isNullOrEmpty()){
                true ->"HAHA NO DATA"
                false -> name
            },
            when(about.isNullOrEmpty()){
                true -> "NO DATA"
                false -> about
            },
            imageView)
    }

    fun logoutUser(){
        authInteractor.logoutUser()
        detailsView.userLoggedOut()
    }
}