package com.example.shiftlabtest.ui.common

import com.example.shiftlabtest.common.Constants
import com.example.shiftlabtest.ui.theme.PaddingMedium
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.shiftlabtest.ui.theme.LabelRegularStyle
import com.example.shiftlabtest.ui.theme.PaddingLarge
import com.example.shiftlabtest.ui.theme.RoundedCornerShapePercentMedium

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthItem(
    icon: ImageVector,
    label: String,
    textFieldValue: String = Constants.EMPTY_STRING,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    enabled: Boolean = true
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Icon(
            imageVector = icon,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            contentDescription = null,
            modifier = Modifier.padding(PaddingMedium)
        )
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = label,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = LabelRegularStyle
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedBorderColor = MaterialTheme.colorScheme.primaryContainer,
                focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                errorBorderColor = MaterialTheme.colorScheme.errorContainer
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = PaddingLarge),
            shape = RoundedCornerShape(percent = RoundedCornerShapePercentMedium),
            enabled = enabled,
            keyboardOptions = keyboardOptions,
            singleLine = true
        )
    }
}