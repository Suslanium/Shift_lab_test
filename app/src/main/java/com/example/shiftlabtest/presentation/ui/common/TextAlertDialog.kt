package com.example.shiftlabtest.presentation.ui.common

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.shiftlabtest.presentation.ui.theme.LabelBoldStyle
import com.example.shiftlabtest.presentation.ui.theme.LabelRegularStyle
import com.example.shiftlabtest.presentation.ui.theme.Subtitle

@Composable
fun TextAlertDialog(
    title: String,
    text: String,
    confirmText: String,
    dismissText: String? = null,
    buttonContainerColor: Color = MaterialTheme.colorScheme.primary,
    buttonContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    AlertDialog(onDismissRequest = onDismiss, title = {
        Text(text = title, style = Subtitle, color = MaterialTheme.colorScheme.onBackground)
    }, text = {
        Text(text = text, style = LabelRegularStyle, color = MaterialTheme.colorScheme.onBackground)
    }, confirmButton = {
        Button(
            onClick = onConfirm,
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonContainerColor, contentColor = buttonContentColor
            ),
        ) {
            Text(
                text = confirmText, style = LabelBoldStyle
            )
        }
    }, dismissButton = {
        if (dismissText != null) {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonContainerColor, contentColor = buttonContentColor
                ),
            ) {
                Text(
                    text = dismissText, style = LabelBoldStyle
                )
            }
        }
    })
}