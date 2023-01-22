package com.example.androidprhome.presentation.view

import android.util.Log
import com.example.androidprhome.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
            val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
                Log.w("exceptionHandler called", exception.toString())
            }
            CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
                try {
                    val job = launch {
                        val doesUserExists = authInteractor.checkUserExists()
                        mainView.userExistsResult(doesUserExists)
                    }
                    job.join()
                    job.cancel()
                }catch (e: Exception){
                    Log.w("exception", "logIn FAILED")
                }
            }
        }
    }