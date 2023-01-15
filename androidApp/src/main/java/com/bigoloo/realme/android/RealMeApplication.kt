package com.bigoloo.realme.android

import android.app.Application
import com.bigoloo.realme.android.di.androidAppModule
import com.bigoloo.realme.di.diaryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RealMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@RealMeApplication)
            modules(diaryModule + androidAppModule)
        }
    }
}