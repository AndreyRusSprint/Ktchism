package com.example.sample

import android.app.Application
import com.example.sample.core.di.dataModule
import com.example.sample.core.di.dataSourceModule
import com.example.sample.core.di.domainModule
import com.example.sample.core.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(
                domainModule,
                dataModule,
                presentationModule,
                dataSourceModule
            ))
        }
    }
}
