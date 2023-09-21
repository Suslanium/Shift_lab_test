package com.example.shiftlabtest.presentation.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shiftlabtest.presentation.ui.screen.MainScreen
import com.example.shiftlabtest.presentation.ui.screen.RegistrationScreen

object ShiftLabTestDestinations {
    const val REGISTRATION = "registration"
    const val MAIN = "main"
}

@Composable
fun ShiftLabTestNavigation(navHostController: NavHostController, onExitClick: () -> Unit) {
    NavHost(navController = navHostController, startDestination = ShiftLabTestDestinations.MAIN) {
        composable(route = ShiftLabTestDestinations.MAIN) {
            MainScreen(navHostController)
            BackHandler {
                onExitClick()
            }
        }
        composable(route = ShiftLabTestDestinations.REGISTRATION) {
            RegistrationScreen(navHostController)
            BackHandler {
                onExitClick()
            }
        }
    }
}