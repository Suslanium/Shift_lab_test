package com.example.shiftlabtest.di

import com.example.shiftlabtest.presentation.viewmodel.MainViewModel
import com.example.shiftlabtest.presentation.viewmodel.RegistrationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun providePresentationModule() = module {
    viewModel {
        RegistrationViewModel(get(), get(), get(), get(), get(), get())
    }
    viewModel {
        MainViewModel(get(), get())
    }
}