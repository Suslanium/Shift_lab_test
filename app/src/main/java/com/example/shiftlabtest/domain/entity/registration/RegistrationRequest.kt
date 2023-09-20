package com.example.shiftlabtest.domain.entity.registration

import java.time.LocalDate

data class RegistrationRequest(
    val name: String,
    val surname: String,
    val birthDate: LocalDate,
    val password: String
)
