package com.example.androidprhome.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidprhome.R
import com.example.androidprhome.databinding.ActivityMainBinding
import com.example.androidprhome.presentation.auth.LoginFragment
import com.example.androidprhome.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null

    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)


        viewModel.checkUserExists()

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_container
        ) as NavHostFragment

        navController = navHostFragment.navController


        viewModel.nav.observe(this) {
            navController.setGraph(it)
        }
    }
}