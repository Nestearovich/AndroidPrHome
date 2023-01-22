package com.example.androidprhome.di

import com.example.androidprhome.domain.auth.AuthInteractor
import com.example.androidprhome.domain.items.ItemsInteractor
import com.example.androidprhome.presentation.auths.DisplayPresenter
import com.example.androidprhome.presentation.auths.LoginPresenter
import com.example.androidprhome.presentation.home.DetailsPresenter
import com.example.androidprhome.presentation.home.ItemsPresenter
import com.example.androidprhome.presentation.view.MainPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {
    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter {
        return MainPresenter(authInteractor)
    }
    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }
    @Provides
    fun provideDisplayPresenter(authInteractor: AuthInteractor): DisplayPresenter {
        return DisplayPresenter()
    }
    @Provides
    fun provideItemsPresenter(itemsInteractor: ItemsInteractor): ItemsPresenter {
        return ItemsPresenter(itemsInteractor)
    }
    @Provides
    fun provideDetailsPresenter(authInteractor: AuthInteractor): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }
}