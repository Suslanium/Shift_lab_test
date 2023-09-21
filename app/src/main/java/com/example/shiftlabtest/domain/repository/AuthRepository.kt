package com.example.shiftlabtest.domain.repository

import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest

interface AuthRepository {

    suspend fun register(request: RegistrationRequest)

    suspend fun isLoggedIn(): Boolean

}