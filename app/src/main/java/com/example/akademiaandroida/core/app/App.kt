package com.example.akademiaandroida.core.app

import android.app.Application
import com.example.akademiaandroida.core.DI.koinInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }


    private fun startKoin() {
        startKoin {
            androidContext(this@App)
            modules(koinInjector)
        }
    }
}

