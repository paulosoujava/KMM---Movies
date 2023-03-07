package com.paulo.movie.android

import android.app.Application
import com.paulo.movie.android.di.appModule
import com.paulo.movie.di.getSharedModules
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(appModule + getSharedModules())
        }
    }
}