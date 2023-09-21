package com.example.shiftlabtest.di

import com.example.shiftlabtest.data.datasource.UserDataSource
import com.example.shiftlabtest.data.repository.AuthRepositoryImpl
import com.example.shiftlabtest.data.repository.UserRepositoryImpl
import com.example.shiftlabtest.domain.repository.AuthRepository
import com.example.shiftlabtest.domain.repository.UserRepository
import com.example.shiftlabtest.domain.usecase.GetUserUseCase
import com.example.shiftlabtest.domain.usecase.LoginCheckUseCase
import com.example.shiftlabtest.domain.usecase.RegisterUseCase
import com.example.shiftlabtest.domain.usecase.ValidateBirthDateUseCase
import com.example.shiftlabtest.domain.usecase.ValidateConfirmPasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateNameUseCase
import com.example.shiftlabtest.domain.usecase.ValidatePasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateSurnameUseCase
import org.koin.dsl.module

private fun provideAuthRepository(userDataSource: UserDataSource): AuthRepository =
    AuthRepositoryImpl(userDataSource)

private fun provideUserRepository(userDataSource: UserDataSource): UserRepository =
    UserRepositoryImpl(userDataSource)

fun provideDomainModule() = module {
    single {
        provideAuthRepository(get())
    }
    single {
        provideUserRepository(get())
    }
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
    factory {
        GetUserUseCase(get())
    }
    factory {
        LoginCheckUseCase(get())
    }
    factory {
        RegisterUseCase(get())
    }
}