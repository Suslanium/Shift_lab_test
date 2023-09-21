package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest
import com.example.shiftlabtest.domain.repository.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(registrationRequest: RegistrationRequest) =
        authRepository.register(registrationRequest)

}