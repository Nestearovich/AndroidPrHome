package com.example.androidprhome.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidprhome.R
import com.example.androidprhome.presentation.auths.LoginFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container, LoginFragment())
        fragmentTransaction.commit()

    }
}