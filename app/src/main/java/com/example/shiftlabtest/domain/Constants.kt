package com.example.shiftlabtest.domain

import java.time.LocalDate

object Constants {
    const val EMPTY_STRING = ""
    const val MIN_PASSWORD_LENGTH = 8
    const val MIN_NAME_LENGTH = 2
    val BIRTH_DATE_RANGE = LocalDate.now().let { now -> LocalDate.of(1900, 1, 1)..now }
}