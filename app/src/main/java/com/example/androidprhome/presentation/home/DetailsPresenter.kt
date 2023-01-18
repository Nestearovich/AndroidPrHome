package com.example.androidprhome.presentation.home

import android.util.Log
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class DetailsPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        detailsView = detailsFragment
    }

    fun getArguments(name: String, about: String, imageView: Int, imageView2: Int) {
        detailsView.displayItemData(
            when (name.isNullOrEmpty()) {
                true -> "HAHA NO DATA"
                false -> name
            },
            when (about.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> about
            },
            imageView
        )
    }

    fun logoutUser() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    detailsView.userLoggedOut(R.navigation.auth_graph)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "logout user FAILED")
            }
        }
    }
}
