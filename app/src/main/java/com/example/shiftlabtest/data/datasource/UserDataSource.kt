package com.example.shiftlabtest.data.datasource

import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest
import com.example.shiftlabtest.domain.entity.user.User

interface UserDataSource {

    suspend fun getUser(): User?

    suspend fun saveUser(userInfo: RegistrationRequest)

}