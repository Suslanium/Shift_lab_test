package com.example.shiftlabtest.presentation.uistate

import java.time.LocalDate

data class RegistrationContent(
    val name: String,
    val surname: String,
    val birthDate: LocalDate?,
    val password: String,
    val confirmPassword: String
)
