package com.example.shiftlabtest.presentation.common

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

data class StringResource(
    @StringRes val id: Int, val args: List<Any> = listOf()
)

@Composable
fun StringResource.asString(): String {
    return stringResource(id = id, formatArgs = args.toTypedArray())
}