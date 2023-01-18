package com.example.androidprhome.presentation.home

import android.util.Log
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val authInteractor: AuthInteractor,
) {
    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment) {
        this.homeView = homeFragment
    }

    fun showUserCreds() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }

        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    val userName = authInteractor.getUserCreds()
                    homeView.showUserCreds(userName)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "show user creds ERROR")
            }
        }
    }

    fun goToDisplay() {
        homeView.goToDisplay(R.navigation.main_graph)
    }
}