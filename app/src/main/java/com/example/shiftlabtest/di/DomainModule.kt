package com.example.shiftlabtest.di

import com.example.shiftlabtest.domain.usecase.ValidateBirthDateUseCase
import com.example.shiftlabtest.domain.usecase.ValidateConfirmPasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateNameUseCase
import com.example.shiftlabtest.domain.usecase.ValidatePasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateSurnameUseCase
import org.koin.dsl.module

fun provideDomainModule() = module {
    factory {
        ValidateBirthDateUseCase()
    }
    factory {
        ValidateNameUseCase()
    }
    factory {
        ValidateSurnameUseCase()
    }
    factory {
        ValidatePasswordUseCase()
    }
    factory {
        ValidateConfirmPasswordUseCase()
    }
}