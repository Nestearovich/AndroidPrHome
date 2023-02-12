package com.example.androidprhome.di.component

import com.example.androidprhome.di.AppModule
import com.example.androidprhome.di.DataBaseModule
import com.example.androidprhome.di.DataModule
import com.example.androidprhome.di.DomainModule
import com.example.androidprhome.presentation.auths.DisplayFragment
import com.example.androidprhome.presentation.auths.LoginFragment
import com.example.androidprhome.presentation.home.DetailsFragment
import com.example.androidprhome.presentation.home.FavoritesFragment
import com.example.androidprhome.presentation.home.HomeFragment
import com.example.androidprhome.presentation.home.ItemsFragment
import com.example.androidprhome.presentation.view.MainActivity
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        DataModule::class,
        DomainModule::class,
    ]
)
@AppComponent.ScreenScope
interface AppComponent {
    annotation class ScreenScope
    fun inject(loginFragment: LoginFragment)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(itemsFragment: ItemsFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(displayFragment: DisplayFragment)
}