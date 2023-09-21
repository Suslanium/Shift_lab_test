package com.example.shiftlabtest.presentation.uistate

import com.example.shiftlabtest.domain.entity.user.User

sealed interface MainScreenUiState {

    object Loading : MainScreenUiState

    object Error : MainScreenUiState

    data class Content(val user: User) : MainScreenUiState

}