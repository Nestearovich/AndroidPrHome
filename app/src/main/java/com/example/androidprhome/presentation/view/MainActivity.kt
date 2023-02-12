package com.example.androidprhome.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidprhome.App
import com.example.androidprhome.R
import com.example.androidprhome.databinding.ActivityMainBinding
import com.example.androidprhome.presentation.auths.LoginFragment
import com.example.androidprhome.presentation.home.HomeFragment
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding!!.root)

        (applicationContext as App).provideAppComponent().inject(this)



        mainPresenter.setView(this)

        mainPresenter.checkUserExists()



    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container,
            when(userExists){
                true -> HomeFragment()
                false ->LoginFragment()
            })
        fragmentTransaction.commit()
    }
}