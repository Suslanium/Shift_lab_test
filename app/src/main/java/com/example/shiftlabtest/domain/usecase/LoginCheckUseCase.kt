package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.repository.AuthRepository

class LoginCheckUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(): Boolean = authRepository.isLoggedIn()

}