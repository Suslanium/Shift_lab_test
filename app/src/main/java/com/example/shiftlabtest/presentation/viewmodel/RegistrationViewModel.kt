package com.example.shiftlabtest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.shiftlabtest.common.Constants
import com.example.shiftlabtest.presentation.uistate.RegistrationContent
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistrationViewModel : ViewModel() {
    val registrationContent: State<RegistrationContent>
        get() = _registrationContent
    private val _registrationContent = mutableStateOf(
        RegistrationContent(
            Constants.EMPTY_STRING,
            Constants.EMPTY_STRING,
            null,
            Constants.EMPTY_STRING,
            Constants.EMPTY_STRING
        )
    )

    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val timeBoundary = LocalDate.now().let { now -> LocalDate.of(1900, 1, 1)..now }

    fun setName(name: String) {
        _registrationContent.value = _registrationContent.value.copy(name = name)
    }

    fun setSurname(surname: String) {
        _registrationContent.value = _registrationContent.value.copy(surname = surname)
    }

    fun setBirthDate(date: LocalDate) {
        _registrationContent.value = _registrationContent.value.copy(birthDate = date)
    }

    fun setPassword(password: String) {
        _registrationContent.value = _registrationContent.value.copy(password = password)
    }

    fun setConfirmPassword(confirmPassword: String) {
        _registrationContent.value =
            _registrationContent.value.copy(confirmPassword = confirmPassword)
    }

    fun register() {

    }
}