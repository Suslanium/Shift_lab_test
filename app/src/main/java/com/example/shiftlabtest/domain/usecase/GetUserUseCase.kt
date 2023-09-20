package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.entity.user.User
import com.example.shiftlabtest.domain.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(): User? = userRepository.getUser()

}