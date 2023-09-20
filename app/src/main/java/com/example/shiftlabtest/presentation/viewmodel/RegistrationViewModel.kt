package com.example.shiftlabtest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftlabtest.domain.entity.registration.RegistrationRequest
import com.example.shiftlabtest.domain.usecase.RegisterUseCase
import com.example.shiftlabtest.domain.usecase.ValidateBirthDateUseCase
import com.example.shiftlabtest.domain.usecase.ValidateConfirmPasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateNameUseCase
import com.example.shiftlabtest.domain.usecase.ValidatePasswordUseCase
import com.example.shiftlabtest.domain.usecase.ValidateSurnameUseCase
import com.example.shiftlabtest.presentation.mapper.ErrorTypeToStringResource
import com.example.shiftlabtest.presentation.uistate.RegistrationFormState
import com.example.shiftlabtest.presentation.uistate.event.RegistrationEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegistrationViewModel(
    private val validateNameUseCase: ValidateNameUseCase,
    private val validateSurnameUseCase: ValidateSurnameUseCase,
    private val validateBirthDateUseCase: ValidateBirthDateUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateConfirmPasswordUseCase: ValidateConfirmPasswordUseCase,
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    val registrationContent: State<RegistrationFormState>
        get() = _registrationContent
    private val _registrationContent = mutableStateOf(RegistrationFormState())

    private val _registrationEventChannel = Channel<RegistrationEvent>()
    val registrationEvents = _registrationEventChannel.receiveAsFlow()

    val dataIsFilled: Boolean
        get() = _registrationContent.value.name.isNotBlank()
                && _registrationContent.value.surname.isNotBlank()
                && _registrationContent.value.birthDate != null
                && _registrationContent.value.password.isNotBlank()
                && _registrationContent.value.confirmPassword.isNotBlank()
                && validationSuccessful

    private val validationSuccessful: Boolean
        get() = _registrationContent.value.nameErrorMessage == null
                && _registrationContent.value.surnameErrorMessage == null
                && _registrationContent.value.birthDateErrorMessage == null
                && _registrationContent.value.passwordErrorMessage == null
                && _registrationContent.value.confirmPasswordErrorMessage == null

    val registrationIsInProgress: State<Boolean>
        get() = _registrationIsInProcess
    private val _registrationIsInProcess = mutableStateOf(false)

    val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    fun setName(name: String) {
        val nameValidationResult = validateNameUseCase(name)
        _registrationContent.value = _registrationContent.value.copy(
            name = name,
            nameErrorMessage = ErrorTypeToStringResource.map[nameValidationResult.errorType]
        )
    }

    fun setSurname(surname: String) {
        val surnameValidationResult = validateSurnameUseCase(surname)
        _registrationContent.value = _registrationContent.value.copy(
            surname = surname,
            surnameErrorMessage = ErrorTypeToStringResource.map[surnameValidationResult.errorType]
        )
    }

    fun setBirthDate(date: LocalDate) {
        val birthDateValidationResult =
            validateBirthDateUseCase(date)
        _registrationContent.value = _registrationContent.value.copy(
            birthDate = date,
            birthDateErrorMessage = ErrorTypeToStringResource.map[birthDateValidationResult.errorType]
        )
    }

    fun setPassword(password: String) {
        val passwordValidationResult = validatePasswordUseCase(password)
        if (_registrationContent.value.confirmPassword.isNotBlank()) {
            val confirmPasswordValidationResult = validateConfirmPasswordUseCase(
                password, _registrationContent.value.confirmPassword
            )
            _registrationContent.value = _registrationContent.value.copy(
                password = password,
                passwordErrorMessage = ErrorTypeToStringResource.map[passwordValidationResult.errorType],
                confirmPasswordErrorMessage = ErrorTypeToStringResource.map[confirmPasswordValidationResult.errorType]
            )
        } else {
            _registrationContent.value = _registrationContent.value.copy(
                password = password,
                passwordErrorMessage = ErrorTypeToStringResource.map[passwordValidationResult.errorType]
            )
        }
    }

    fun setConfirmPassword(confirmPassword: String) {
        val confirmPasswordValidationResult = validateConfirmPasswordUseCase(
            _registrationContent.value.password, confirmPassword
        )
        _registrationContent.value = _registrationContent.value.copy(
            confirmPassword = confirmPassword,
            confirmPasswordErrorMessage = ErrorTypeToStringResource.map[confirmPasswordValidationResult.errorType]
        )
    }

    fun register() {
        if (dataIsFilled) {
            viewModelScope.launch(Dispatchers.IO) {
                _registrationIsInProcess.value = true
                try {
                    val request = RegistrationRequest(
                        _registrationContent.value.name,
                        _registrationContent.value.surname,
                        _registrationContent.value.birthDate!!,
                        _registrationContent.value.password
                    )
                    registerUseCase(request)
                    _registrationEventChannel.send(RegistrationEvent.Success)
                } catch (_: Exception) {
                    _registrationEventChannel.send(RegistrationEvent.Error)
                    _registrationIsInProcess.value = false
                }
            }
        }
    }
}