package com.example.shiftlabtest.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shiftlabtest.domain.usecase.GetUserUseCase
import com.example.shiftlabtest.domain.usecase.LoginCheckUseCase
import com.example.shiftlabtest.presentation.uistate.MainScreenUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val loginCheckUseCase: LoginCheckUseCase, private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val mainScreenUiState: State<MainScreenUiState>
        get() = _mainScreenState

    private var _mainScreenState: MutableState<MainScreenUiState> =
        mutableStateOf(MainScreenUiState.Loading)

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            //Separate CoroutineExceptionHandler is not used here because
            //withContext is not available in CoroutineExceptionHandler
            try {
                val isLoggedIn = loginCheckUseCase()
                if (!isLoggedIn) {
                    //Open registration screen
                }
                val user = getUserUseCase()
                if (user == null) {
                    withContext(Dispatchers.Main) {
                        _mainScreenState.value = MainScreenUiState.Error
                    }
                    return@launch
                }
                withContext(Dispatchers.Main) {
                    _mainScreenState.value = MainScreenUiState.Content(user)
                }
            } catch (_: Exception) {
                withContext(Dispatchers.Main) {
                    _mainScreenState.value = MainScreenUiState.Error
                }
            }
        }
    }
}