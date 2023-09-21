package com.example.shiftlabtest.presentation.uistate

import com.example.shiftlabtest.domain.Constants
import com.example.shiftlabtest.presentation.common.StringResource
import java.time.LocalDate

data class RegistrationFormState(
    val name: String = Constants.EMPTY_STRING,
    val nameErrorMessage: StringResource? = null,
    val surname: String = Constants.EMPTY_STRING,
    val surnameErrorMessage: StringResource? = null,
    val birthDate: LocalDate? = null,
    val birthDateErrorMessage: StringResource? = null,
    val password: String = Constants.EMPTY_STRING,
    val passwordErrorMessage: StringResource? = null,
    val confirmPassword: String = Constants.EMPTY_STRING,
    val confirmPasswordErrorMessage: StringResource? = null
)
