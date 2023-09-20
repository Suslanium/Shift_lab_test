package com.example.shiftlabtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.shiftlabtest.presentation.ui.navigation.ShiftLabTestNavigation
import com.example.shiftlabtest.presentation.ui.theme.ShiftLabTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShiftLabTestTheme {
                val navHostController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ShiftLabTestNavigation(navHostController = navHostController, onExitClick = {
                        finish()
                    })
                }
            }
        }
    }
}