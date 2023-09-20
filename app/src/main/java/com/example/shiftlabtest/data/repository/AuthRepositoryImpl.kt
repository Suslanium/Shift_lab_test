package com.example.shiftlabtest.data.repository

import com.example.shiftlabtest.data.datasource.UserDataSource
import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest
import com.example.shiftlabtest.domain.repository.AuthRepository

class AuthRepositoryImpl(private val userDataSource: UserDataSource) : AuthRepository {

    override suspend fun register(request: RegistrationRequest) = userDataSource.saveUser(request)

    override suspend fun isLoggedIn(): Boolean = userDataSource.getUser() != null

}