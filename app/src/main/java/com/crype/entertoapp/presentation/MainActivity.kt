package com.crype.entertoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.crype.entertoapp.presentation.components.TopBar
import com.crype.entertoapp.presentation.navigation.NavGraph
import com.crype.entertoapp.presentation.navigation.Screens
import com.crype.entertoapp.presentation.ui.theme.EnterToAppTheme
import com.crype.entertoapp.presentation.ui.theme.MainBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EnterToAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MainBackground),
                    topBar = {
                        if (!navController.currentDestination?.route.equals(Screens.EnterNumberScreen.route))
                            TopBar {
                                navController.popBackStack()
                            }
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(horizontal = 20.dp)
                    ) {
                        NavGraph(
                            navController = navController,
                            startDestination = Screens.EnterNumberScreen.route
                        )
                    }
                }
            }
        }
    }
}
