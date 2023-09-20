package com.example.shiftlabtest.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.example.shiftlabtest.R
import com.example.shiftlabtest.presentation.ui.common.TextAlertDialog
import com.example.shiftlabtest.presentation.ui.common.TextButton
import com.example.shiftlabtest.presentation.ui.theme.IconSizeLarge
import com.example.shiftlabtest.presentation.ui.theme.Subtitle

@Composable
fun MainScreen() {
    var shouldShowGreetingDialog by remember { mutableStateOf(false) }

    if (shouldShowGreetingDialog) {
        TextAlertDialog(title = stringResource(id = R.string.dialog_title, "Test", "Test"),
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