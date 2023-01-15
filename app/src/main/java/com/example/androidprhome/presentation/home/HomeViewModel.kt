package com.example.androidprhome.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import com.example.androidprhome.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor,
) : ViewModel() {

    private val _userCred = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCred

    private val _nav = MutableLiveData<Int>()
    val nav: LiveData<Int> = _nav

    fun showUserData() {
        viewModelScope.launch {
            try {
                _userCred.value = authInteractor.getUserCreds()
            }catch (e:java.lang.Exception){
                Log.w("exception", "no user data ")
            }
        }
    }
    fun goToOnBoarding(){
        _nav.value = R.navigation.main_graph
    }
}