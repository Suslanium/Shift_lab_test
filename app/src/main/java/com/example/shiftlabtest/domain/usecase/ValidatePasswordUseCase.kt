package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.Constants.MIN_PASSWORD_LENGTH
import com.example.shiftlabtest.domain.entity.registration.validation.PasswordValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.FieldValidationResult

class ValidatePasswordUseCase {

    operator fun invoke(password: String): FieldValidationResult {
        if (password.isBlank()) {
            return FieldValidationResult(
                successful = false, errorType = PasswordValidationErrorType.BLANK
            )
        }
        if (password.length < MIN_PASSWORD_LENGTH) {
            return FieldValidationResult(
                successful = false, errorType = PasswordValidationErrorType.TOO_SHORT
            )
        }

        return validatePasswordContents(password)
    }

    private fun validatePasswordContents(password: String): FieldValidationResult {
        val containsDigit = password.any { it.isDigit() }
        val containsLetter = password.any { it.isLetter() }
        val containsSpecialSymbol = password.any { !it.isDigit() && !it.isLetter() }

        if (containsLetter && !containsDigit && !containsSpecialSymbol) {
            return FieldValidationResult(
                successful = false,
                errorType = PasswordValidationErrorType.MUST_CONTAIN_DIGIT_AND_SPECIAL_SYMBOL
            )
        }
        if (containsDigit && !containsLetter && !containsSpecialSymbol) {
            return FieldValidationResult(
                successful = false,
                errorType = PasswordValidationErrorType.MUST_CONTAIN_LETTER_AND_SPECIAL_SYMBOL
            )
        }
        if (containsSpecialSymbol && !containsDigit && !containsLetter) {
            return FieldValidationResult(
                successful = false,
                errorType = PasswordValidationErrorType.MUST_CONTAIN_DIGIT_AND_LETTER
            )
        }
        if (!containsDigit) {
            return FieldValidationResult(
                successful = false, errorType = PasswordValidationErrorType.MUST_CONTAIN_DIGIT
            )
        }
        if (!containsLetter) {
            return FieldValidationResult(
                successful = false, errorType = PasswordValidationErrorType.MUST_CONTAIN_LETTER
            )
        }
        if (!containsSpecialSymbol) {
            return FieldValidationResult(
                successful = false,
                errorType = PasswordValidationErrorType.MUST_CONTAIN_SPECIAL_SYMBOL
            )
        }
        return FieldValidationResult(
            successful = true
        )
    }

}