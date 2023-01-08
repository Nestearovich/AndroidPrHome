package com.example.androidprhome.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidprhome.R

object Navigation {
    fun fmReplace(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean,
    ) {
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack("")
                .replace(R.id.activity_container, fragment)
                .commit()
        } else {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }

    }
}