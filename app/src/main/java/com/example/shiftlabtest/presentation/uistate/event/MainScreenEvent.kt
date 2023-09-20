package com.example.shiftlabtest.presentation.uistate.event

sealed interface MainScreenEvent {
    object AuthenticationRequired : MainScreenEvent
}