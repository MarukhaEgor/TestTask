package com.example.testtask

import android.app.Application
import com.example.testtask.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        koinStart()
    }

    private fun koinStart() {
        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }
}