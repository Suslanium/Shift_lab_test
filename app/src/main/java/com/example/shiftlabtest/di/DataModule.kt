package com.example.shiftlabtest.di

import android.content.Context
import com.example.shiftlabtest.data.datasource.UserDataSource
import com.example.shiftlabtest.data.datasource.UserLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private fun provideUserDataSource(context: Context): UserDataSource =
    UserLocalDataSourceImpl(context)

fun provideDataModule() = module {
    single {
        provideUserDataSource(androidContext())
    }
}