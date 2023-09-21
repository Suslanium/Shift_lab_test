package com.example.shiftlabtest.domain.entity.registration.validation

data class FieldValidationResult(
    val successful: Boolean,
    val errorType: Enum<*>? = null
)