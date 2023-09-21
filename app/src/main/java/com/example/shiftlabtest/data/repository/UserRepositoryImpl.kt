package com.example.shiftlabtest.data.repository

import com.example.shiftlabtest.data.datasource.UserDataSource
import com.example.shiftlabtest.domain.entity.user.User
import com.example.shiftlabtest.domain.repository.UserRepository

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override suspend fun getUser(): User? = userDataSource.getUser()

}