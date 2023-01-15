package com.example.androidprhome.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidprhome.R
import com.example.androidprhome.domain.auth.AuthInteractor
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
): ViewModel() {
    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun logoutUser() {
        viewModelScope.launch {
                authInteractor.logoutUser()
                _nav.value = R.navigation.auth_graph
        }
    }
}