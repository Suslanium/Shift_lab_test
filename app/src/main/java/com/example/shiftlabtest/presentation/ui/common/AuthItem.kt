package com.example.shiftlabtest.presentation.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.shiftlabtest.common.Constants
import com.example.shiftlabtest.presentation.ui.theme.LabelRegularStyle
import com.example.shiftlabtest.presentation.ui.theme.RoundedCornerShapePercentMedium

@Composable
fun AuthItem(
    icon: ImageVector,
    label: String,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    clickable: Boolean = false,
    onClick: () -> Unit = {},
    widthFraction: Float = 1f
) {
    val interactionSource = remember { MutableInteractionSource() }
    OutlinedTextField(
        leadingIcon = {
            Icon(
                imageVector = icon,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                contentDescription = null,
            )
        },
        value = textFieldValue,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = LabelRegularStyle
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorBorderColor = MaterialTheme.colorScheme.errorContainer,
            disabledBorderColor = MaterialTheme.colorScheme.primaryContainer,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .clickableChecked(enabled = clickable, onClick = onClick, interactionSource),
        shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        singleLine = true
    )
}

//This extension function is required because using regular clickable
//modifier with enabled set to false will cause the text field to be inaccessible
private fun Modifier.clickableChecked(
    enabled: Boolean, onClick: () -> Unit, interactionSource: MutableInteractionSource
): Modifier {
    return if (enabled) {
        then(
            Modifier.clickable(
                enabled = true,
                onClick = onClick,
                interactionSource = interactionSource,
                indication = null
            )
        )
    } else {
        this
    }
}