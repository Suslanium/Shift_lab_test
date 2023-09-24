package com.example.shiftlabtest.presentation.ui.screen.registration.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.shiftlabtest.domain.Constants
import com.example.shiftlabtest.presentation.ui.theme.LabelRegularStyle
import com.example.shiftlabtest.presentation.ui.theme.RoundedCornerShapePercentMedium

@Composable
fun PasswordField(
    visibilityIcon: ImageVector,
    visibilityOffIcon: ImageVector,
    label: String,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true,
    widthFraction: Float = 1f,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        leadingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = if (isPasswordVisible) visibilityOffIcon else visibilityIcon,
                    contentDescription = null
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
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
            errorContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorBorderColor = MaterialTheme.colorScheme.error,
            disabledBorderColor = if (!enabled && isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primaryContainer,
            focusedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        modifier = Modifier.fillMaxWidth(widthFraction),
        shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        supportingText = {
            if (isError && errorMessage != null) {
                Text(
                    text = errorMessage,
                    modifier = Modifier.fillMaxWidth(widthFraction),
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        isError = isError
    )
}