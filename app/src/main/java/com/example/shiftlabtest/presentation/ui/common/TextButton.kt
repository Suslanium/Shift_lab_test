package com.example.shiftlabtest.presentation.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.example.shiftlabtest.presentation.ui.theme.IconSizeMedium
import com.example.shiftlabtest.presentation.ui.theme.LabelRegularStyle
import com.example.shiftlabtest.presentation.ui.theme.PaddingMedium
import com.example.shiftlabtest.presentation.ui.theme.SmallButtonCornerRadius

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    buttonColor: Color = MaterialTheme.colorScheme.primary,
    buttonContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    buttonContentPadding: PaddingValues = PaddingValues(PaddingMedium),
    buttonShape: Shape = RoundedCornerShape(SmallButtonCornerRadius),
    buttonTextStyle: TextStyle = LabelRegularStyle,
    buttonIconSize: Dp = IconSizeMedium,
    iconContentDescription: String = ""
) {
    Button(
        modifier = modifier.height(IntrinsicSize.Max),
        onClick = onClick,
        contentPadding = buttonContentPadding,
        shape = buttonShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor, contentColor = buttonContentColor
        ),
        enabled = enabled
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = iconContentDescription,
                modifier = Modifier.size(buttonIconSize)
            )
        }
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
            Text(
                text = text, style = buttonTextStyle, textAlign = TextAlign.Center
            )
        }
    }
}