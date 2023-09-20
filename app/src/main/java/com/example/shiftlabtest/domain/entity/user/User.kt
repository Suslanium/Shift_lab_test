package com.example.shiftlabtest.domain.entity.user

import java.time.LocalDate

data class User(
    val name: String,
    val surname: String,
    val birthDate: LocalDate
)
