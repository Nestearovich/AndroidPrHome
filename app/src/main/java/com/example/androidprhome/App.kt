package com.example.androidprhome

import android.app.Application
import com.example.androidprhome.di.AppModule
import com.example.androidprhome.di.component.AppComponent
import com.example.androidprhome.di.component.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    fun provideAppComponent(): AppComponent {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
        return appComponent
    }
}