package com.example.shiftlabtest.domain.repository

import com.example.shiftlabtest.domain.entity.user.User

interface UserRepository {

    suspend fun getUser(): User?

}