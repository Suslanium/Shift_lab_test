package com.example.shiftlabtest.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.shiftlabtest.R
import com.example.shiftlabtest.domain.Constants
import com.example.shiftlabtest.domain.Constants.BIRTH_DATE_RANGE
import com.example.shiftlabtest.presentation.common.asString
import com.example.shiftlabtest.presentation.ui.common.AuthItem
import com.example.shiftlabtest.presentation.ui.common.TextAlertDialog
import com.example.shiftlabtest.presentation.ui.common.TextButton
import com.example.shiftlabtest.presentation.ui.navigation.ShiftLabTestDestinations
import com.example.shiftlabtest.presentation.ui.theme.RegistrationContentWidthFraction
import com.example.shiftlabtest.presentation.ui.theme.RegistrationPrimaryElementWeight
import com.example.shiftlabtest.presentation.ui.theme.RegistrationSecondaryElementWeight
import com.example.shiftlabtest.presentation.ui.theme.RegistrationSpacerWeight
import com.example.shiftlabtest.presentation.ui.theme.Title
import com.example.shiftlabtest.presentation.uistate.event.RegistrationEvent
import com.example.shiftlabtest.presentation.viewmodel.RegistrationViewModel
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegistrationScreen(navHostController: NavHostController) {
    val registrationViewModel: RegistrationViewModel = koinViewModel()
    var shouldShowErrorDialog by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        registrationViewModel.registrationEvents.collect { event ->
            when (event) {
                is RegistrationEvent.Success -> navHostController.navigate(ShiftLabTestDestinations.MAIN)
                is RegistrationEvent.Error -> shouldShowErrorDialog = true
            }
        }
    }

    if (shouldShowErrorDialog) {
        TextAlertDialog(title = stringResource(id = R.string.error),
            text = stringResource(id = R.string.something_went_wrong),
            confirmText = stringResource(id = R.string.ok),
            onConfirm = { shouldShowErrorDialog = false },
            onDismiss = { shouldShowErrorDialog = false })
    }

    RegistrationContent(registrationViewModel)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun RegistrationContent(registrationViewModel: RegistrationViewModel) {
    val registrationIsInProgress by remember { registrationViewModel.registrationIsInProgress }
    val calendarState = rememberUseCaseState(visible = false)
    CalendarDialog(
        state = calendarState, config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.MONTH,
            boundary = BIRTH_DATE_RANGE
        ), selection = CalendarSelection.Date(onSelectDate = registrationViewModel::setBirthDate)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(RegistrationSpacerWeight))
        Box(
            modifier = Modifier.weight(RegistrationSecondaryElementWeight),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.welcome),
                style = Title,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier.weight(RegistrationPrimaryElementWeight),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RegistrationForm(calendarState, registrationViewModel, registrationIsInProgress)
        }
        Box(
            modifier = Modifier.weight(RegistrationSecondaryElementWeight),
            contentAlignment = Alignment.Center
        ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(RegistrationContentWidthFraction),
                text = stringResource(id = R.string.register),
                icon = ImageVector.vectorResource(R.drawable.double_arrow_right_icon),
                onClick = registrationViewModel::register,
                enabled = registrationViewModel.dataIsFilled && !registrationIsInProgress
            )
        }
        Spacer(modifier = Modifier.weight(RegistrationSpacerWeight))
    }
}

@Composable
private fun RegistrationForm(
    calendarState: UseCaseState, registrationViewModel: RegistrationViewModel, registrationIsInProgress: Boolean
) {
    val registrationContent by remember { registrationViewModel.registrationContent }
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.name),
        textFieldValue = registrationContent.name,
        onValueChange = registrationViewModel::setName,
        widthFraction = RegistrationContentWidthFraction,
        isError = registrationContent.nameErrorMessage != null,
        errorMessage = registrationContent.nameErrorMessage?.asString(),
        enabled = !registrationIsInProgress
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.surname),
        textFieldValue = registrationContent.surname,
        onValueChange = registrationViewModel::setSurname,
        widthFraction = RegistrationContentWidthFraction,
        isError = registrationContent.surnameErrorMessage != null,
        errorMessage = registrationContent.surnameErrorMessage?.asString(),
        enabled = !registrationIsInProgress
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.calendar_icon),
        label = stringResource(id = R.string.birthdate),
        textFieldValue = registrationContent.birthDate?.format(registrationViewModel.dateFormat)
            ?: Constants.EMPTY_STRING,
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction,
        enabled = false,
        clickable = !registrationIsInProgress,
        onClick = {
            calendarState.show()
        },
        isError = registrationContent.birthDateErrorMessage != null,
        errorMessage = registrationContent.birthDateErrorMessage?.asString()
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.password),
        textFieldValue = registrationContent.password,
        onValueChange = registrationViewModel::setPassword,
        widthFraction = RegistrationContentWidthFraction,
        isError = registrationContent.passwordErrorMessage != null,
        errorMessage = registrationContent.passwordErrorMessage?.asString(),
        enabled = !registrationIsInProgress
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.confirm_password),
        textFieldValue = registrationContent.confirmPassword,
        onValueChange = registrationViewModel::setConfirmPassword,
        widthFraction = RegistrationContentWidthFraction,
        isError = registrationContent.confirmPasswordErrorMessage != null,
        errorMessage = registrationContent.confirmPasswordErrorMessage?.asString(),
        enabled = !registrationIsInProgress
    )
}