package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.Constants.MIN_NAME_LENGTH
import com.example.shiftlabtest.domain.entity.registration.validation.FieldValidationResult
import com.example.shiftlabtest.domain.entity.registration.validation.SurnameValidationErrorType

class ValidateSurnameUseCase {

    operator fun invoke(name: String): FieldValidationResult {
        if (name.isBlank()) {
            return FieldValidationResult(
                successful = false, errorType = SurnameValidationErrorType.BLANK
            )
        }
        if (name.length < MIN_NAME_LENGTH) {
            return FieldValidationResult(
                successful = false, errorType = SurnameValidationErrorType.TOO_SHORT
            )
        }
        return FieldValidationResult(
            successful = true
        )
    }

}