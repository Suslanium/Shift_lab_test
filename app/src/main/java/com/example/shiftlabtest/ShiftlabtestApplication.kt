package com.example.shiftlabtest

import android.app.Application
import com.example.shiftlabtest.di.provideDataModule
import com.example.shiftlabtest.di.provideDomainModule
import com.example.shiftlabtest.di.providePresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShiftlabtestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShiftlabtestApplication)
            modules(
                providePresentationModule(),
                provideDomainModule(),
                provideDataModule()
            )
        }
    }
}