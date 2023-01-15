package com.example.androidprhome.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidprhome.R
import javax.inject.Inject

class DisplayViewModel @Inject constructor(): ViewModel() {

    private val _nav = MutableLiveData<NavToItems?>()
    val nav: LiveData<NavToItems?> = _nav

    fun finishButtonClicked() {
        _nav.value = NavToItems(
            R.id.displayFragment,
            R.id.action_displayFragment_to_itemsFragment)
    }

    fun finishPerformed() {
        _nav.value = null
    }
}


data class  NavToItems(
    val destinationId: Int,
    val removeFragmentId: Int
)
