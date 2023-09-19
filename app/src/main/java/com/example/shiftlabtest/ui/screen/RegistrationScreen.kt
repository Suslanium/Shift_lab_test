package com.example.shiftlabtest.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.shiftlabtest.R
import com.example.shiftlabtest.ui.common.AuthItem
import com.example.shiftlabtest.ui.common.TextButton
import com.example.shiftlabtest.ui.theme.RegistrationContentWidthFraction
import com.example.shiftlabtest.ui.theme.RegistrationPrimaryElementWeight
import com.example.shiftlabtest.ui.theme.RegistrationSecondaryElementWeight
import com.example.shiftlabtest.ui.theme.RegistrationSpacerWeight
import com.example.shiftlabtest.ui.theme.ShiftLabTestTheme
import com.example.shiftlabtest.ui.theme.Title

@Composable
fun RegistrationScreen() {
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
            RegistrationForm()
        }
        Box(
            modifier = Modifier.weight(RegistrationSecondaryElementWeight),
            contentAlignment = Alignment.Center
        ) {
            TextButton(
                modifier = Modifier.fillMaxWidth(0.85f),
                text = stringResource(id = R.string.register),
                icon = ImageVector.vectorResource(R.drawable.double_arrow_right_icon)
            )
        }
        Spacer(modifier = Modifier.weight(RegistrationSpacerWeight))
    }
}

@Composable
private fun RegistrationForm() {
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.name),
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.person_icon),
        label = stringResource(id = R.string.surname),
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.calendar_icon),
        label = stringResource(id = R.string.birthdate),
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction,
        enabled = false
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.password),
        onValueChange = {},
        widthFraction = RegistrationContentWidthFraction
    )
    AuthItem(
        icon = ImageVector.vectorResource(id = R.drawable.password_icon),
        label = stringResource(id = R.string.confirm_password),
        onValueChange = {},
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