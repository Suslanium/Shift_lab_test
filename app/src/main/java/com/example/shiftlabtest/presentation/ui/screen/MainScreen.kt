package com.example.shiftlabtest.presentation.ui.screen

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.example.shiftlabtest.R
import com.example.shiftlabtest.domain.Constants
import com.example.shiftlabtest.domain.entity.user.User
import com.example.shiftlabtest.presentation.ui.common.TextAlertDialog
import com.example.shiftlabtest.presentation.ui.common.TextButton
import com.example.shiftlabtest.presentation.ui.navigation.ShiftLabTestDestinations
import com.example.shiftlabtest.presentation.ui.theme.IconSizeLarge
import com.example.shiftlabtest.presentation.ui.theme.Subtitle
import com.example.shiftlabtest.presentation.uistate.MainScreenUiState
import com.example.shiftlabtest.presentation.uistate.event.MainScreenEvent
import com.example.shiftlabtest.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(navHostController: NavHostController) {
    val viewModel: MainViewModel = koinViewModel()
    val screenState by remember { viewModel.mainScreenUiState }

    LaunchedEffect(true) {
        viewModel.mainScreenEvents.collect { event ->
            when (event) {
                is MainScreenEvent.AuthenticationRequired -> navHostController.navigate(
                    ShiftLabTestDestinations.REGISTRATION
                )
            }
        }
    }

    Crossfade(targetState = screenState, label = Constants.EMPTY_STRING) { state ->
        when (state) {
            is MainScreenUiState.Content -> {
                MainContent(user = state.user)
            }

            MainScreenUiState.Error -> Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.something_went_wrong), style = Subtitle)
            }

            MainScreenUiState.Loading -> Unit
        }
    }


}

@Composable
private fun MainContent(user: User) {
    var shouldShowGreetingDialog by remember { mutableStateOf(false) }

    if (shouldShowGreetingDialog) {
        TextAlertDialog(title = stringResource(id = R.string.dialog_title, user.name, user.surname),
            text = stringResource(id = R.string.dialog_message),
            confirmText = stringResource(id = R.string.ok),
            onConfirm = { shouldShowGreetingDialog = false },
            onDismiss = { shouldShowGreetingDialog = false })
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextButton(text = stringResource(id = R.string.greeting),
            icon = ImageVector.vectorResource(id = R.drawable.waving_hand_icon),
            buttonTextStyle = Subtitle,
            buttonIconSize = IconSizeLarge,
            onClick = {
                shouldShowGreetingDialog = true
            })
    }
}