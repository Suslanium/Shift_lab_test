package com.example.shiftlabtest.domain.usecase

import com.example.shiftlabtest.domain.entity.registration.validation.BirthDateValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.FieldValidationResult
import java.time.LocalDate

class ValidateBirthDateUseCase {

    operator fun invoke(birthDate: LocalDate?): FieldValidationResult {
        if (birthDate == null) {
            return FieldValidationResult(
                successful = false, errorType = BirthDateValidationErrorType.BLANK
            )
        }
        return FieldValidationResult(
            successful = true
        )
    }
}