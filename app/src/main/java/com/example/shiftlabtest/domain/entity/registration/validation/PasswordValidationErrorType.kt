package com.example.shiftlabtest.domain.entity.registration.validation

enum class PasswordValidationErrorType {
    BLANK,
    TOO_SHORT,
    MUST_CONTAIN_SPECIAL_SYMBOL,
    MUST_CONTAIN_DIGIT,
    MUST_CONTAIN_LETTER,
    MUST_CONTAIN_DIGIT_AND_SPECIAL_SYMBOL,
    MUST_CONTAIN_LETTER_AND_SPECIAL_SYMBOL,
    MUST_CONTAIN_DIGIT_AND_LETTER
}