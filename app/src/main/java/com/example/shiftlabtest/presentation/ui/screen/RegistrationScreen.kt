package com.example.shiftlabtest.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.shiftlabtest.R
import com.example.shiftlabtest.common.Constants
import com.example.shiftlabtest.presentation.ui.common.AuthItem
import com.example.shiftlabtest.presentation.ui.common.TextButton
import com.example.shiftlabtest.presentation.ui.theme.RegistrationContentWidthFraction
import com.example.shiftlabtest.presentation.ui.theme.RegistrationPrimaryElementWeight
import com.example.shiftlabtest.presentation.ui.theme.RegistrationSecondaryElementWeight
import com.example.shiftlabtest.presentation.ui.theme.RegistrationSpacerWeight
import com.example.shiftlabtest.presentation.ui.theme.ShiftLabTestTheme
import com.example.shiftlabtest.presentation.ui.theme.Title
import com.example.shiftlabtest.presentation.viewmodel.RegistrationViewModel
import com.maxkeppeker.sheets.core.models.base.UseCaseState
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen() {
    val registrationViewModel: RegistrationViewModel = koinViewModel()

    val calendarState = rememberUseCaseState(visible = false)
    CalendarDialog(
        state = calendarState, config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.MONTH,
            boundary = registrationViewModel.timeBoundary
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
            RegistrationForm(calendarState, registrationViewModel)
        }
        Box(
            modifier = Modifier.weight(RegistrationSecondaryElementWeight),
            contentAlignment = Alignment.Center
        ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(RegistrationContentWidthFraction),
                text = stringResource(id = R.string.register),
                icon = ImageVector.vectorResource(R.drawable.double_arrow_right_icon),
                onClick = registrationViewModel::register
            )
        }
        Spacer(modifier = Modifier.weight(RegistrationSpacerWeight))
    }
}

@Composable
private fun RegistrationForm(
    calendarState: UseCaseState, registrationViewModel: RegistrationViewModel
) {
    val registrationContent by remember { registrationViewModel.registrationContent }
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.name),
        textFieldValue = registrationContent.name,
        onValueChange = registrationViewModel::setName,
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.surname),
        textFieldValue = registrationContent.surname,
        onValueChange = registrationViewModel::setSurname,
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(icon = ImageVector.vectorResource(id = R.drawable.calendar_icon),
        label = stringResource(id = R.string.birthdate),
        textFieldValue = registrationContent.birthDate?.format(registrationViewModel.dateFormat)
            ?: Constants.EMPTY_STRING,
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction,
        enabled = false,
        clickable = true,
        onClick = {
            calendarState.show()
        })
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.password),
        textFieldValue = registrationContent.password,
        onValueChange = registrationViewModel::setPassword,
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.confirm_password),
        textFieldValue = registrationContent.confirmPassword,
        onValueChange = registrationViewModel::setConfirmPassword,
        widthFraction = RegistrationContentWidthFraction
    )
}

@Preview
@Composable
fun PreviewRegistrationScreen() {
    ShiftLabTestTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            RegistrationScreen()
        }
    }
}