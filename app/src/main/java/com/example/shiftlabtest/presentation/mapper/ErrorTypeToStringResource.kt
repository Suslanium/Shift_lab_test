package com.example.shiftlabtest.presentation.mapper

import com.example.shiftlabtest.R
import com.example.shiftlabtest.domain.Constants.MIN_NAME_LENGTH
import com.example.shiftlabtest.domain.Constants.MIN_PASSWORD_LENGTH
import com.example.shiftlabtest.domain.entity.registration.validation.BirthDateValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.ConfirmPasswordValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.NameValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.PasswordValidationErrorType
import com.example.shiftlabtest.domain.entity.registration.validation.SurnameValidationErrorType
import com.example.shiftlabtest.presentation.common.StringResource

object ErrorTypeToStringResource {

    val map = mapOf(
        BirthDateValidationErrorType.BLANK to StringResource(R.string.blank_birthdate),
        ConfirmPasswordValidationErrorType.BLANK to StringResource(R.string.confirm_pass_blank),
        ConfirmPasswordValidationErrorType.PASSWORDS_DO_NOT_MATCH to StringResource(R.string.passwords_dont_match),
        NameValidationErrorType.BLANK to StringResource(R.string.blank_name),
        NameValidationErrorType.TOO_SHORT to StringResource(
            R.string.name_too_short, listOf(MIN_NAME_LENGTH)
        ),
        SurnameValidationErrorType.BLANK to StringResource(R.string.blank_surname),
        SurnameValidationErrorType.TOO_SHORT to StringResource(
            R.string.surname_too_short, listOf(MIN_NAME_LENGTH)
        ),
        PasswordValidationErrorType.BLANK to StringResource(R.string.password_blank),
        PasswordValidationErrorType.TOO_SHORT to StringResource(
            R.string.password_too_short, listOf(MIN_PASSWORD_LENGTH)
        ),
        PasswordValidationErrorType.MUST_CONTAIN_LETTER to StringResource(R.string.password_letter),
        PasswordValidationErrorType.MUST_CONTAIN_DIGIT to StringResource(R.string.password_digit),
        PasswordValidationErrorType.MUST_CONTAIN_SPECIAL_SYMBOL to StringResource(R.string.password_spec_symbol),
        PasswordValidationErrorType.MUST_CONTAIN_DIGIT_AND_LETTER to StringResource(R.string.password_digit_letter),
        PasswordValidationErrorType.MUST_CONTAIN_LETTER_AND_SPECIAL_SYMBOL to StringResource(R.string.password_letter_spec_symbol),
        PasswordValidationErrorType.MUST_CONTAIN_DIGIT_AND_SPECIAL_SYMBOL to StringResource(R.string.password_digit_spec_symbol)
    )

}