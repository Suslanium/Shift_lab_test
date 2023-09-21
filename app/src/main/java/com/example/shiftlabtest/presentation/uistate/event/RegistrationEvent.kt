package com.example.shiftlabtest.presentation.uistate.event

sealed interface RegistrationEvent {

    object Success : RegistrationEvent

    object Error : RegistrationEvent

}