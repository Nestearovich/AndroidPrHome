package com.example.androidprhome.presentation.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun loginUser(userName: String, userPassword: String) {
        viewModelScope.launch {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.value = R.id.action_loginFragment2_to_homeFragment
            }catch (e:java.lang.Exception){
                Log.w("exception","Login FAILED")
            }
        }
    }
    fun userNavigated(){
        _nav.value = null
    }
}