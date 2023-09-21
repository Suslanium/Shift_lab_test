package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.entity.registration.validation.ConfirmPasswordValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.FieldValidationResult

class ValidateConfirmPasswordUseCase {

    operator fun invoke(
        password: String, confirmPassword: String
    ): FieldValidationResult {
        if (confirmPassword.isBlank()) {
            return FieldValidationResult(
                successful = false, errorType = ConfirmPasswordValidationErrorType.BLANK
            )
        }
        if (password != confirmPassword) {
            return FieldValidationResult(
                successful = false,
                errorType = ConfirmPasswordValidationErrorType.PASSWORDS_DO_NOT_MATCH
            )
        }
        return FieldValidationResult(
            successful = true
        )
    }

}