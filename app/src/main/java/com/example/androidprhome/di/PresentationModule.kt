package com.example.androidprhome.di

import com.example.androidprhome.domain.auth.AuthInteractor
import com.example.androidprhome.domain.items.ItemsInteractor
import com.example.androidprhome.presentation.auths.LoginPresenter
import com.example.androidprhome.presentation.home.ItemsPresenter
import dagger.Provides

class PresentationModule {
    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter{
        return MainPresenter(authInteractor)
    }
    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }
    @Provides
    fun provideOnBoardingPresenter(authInteractor: AuthInteractor): OnBoardingPresenter {
        return OnBoardingPresenter()
    }
    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }
    @Provides
    fun provideDetailPresenter(authInteractor: AuthInteractor): DetailPresenter {
        return DetailPresenter(authInteractor)
    }
}