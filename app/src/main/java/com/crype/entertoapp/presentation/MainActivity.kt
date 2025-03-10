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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.crype.entertoapp.presentation.components.TopBar
import com.crype.entertoapp.presentation.navigation.NavGraph
import com.crype.entertoapp.presentation.navigation.Screens
import com.crype.entertoapp.presentation.ui.theme.MainBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val startDestination = Screens.EnterNumberScreen.route
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MainBackground),
                topBar = {
                    val currentDestination = navController
                        .currentBackStackEntryAsState().value?.destination?.route
                    if (currentDestination != startDestination) {
                        TopBar { navController.popBackStack() }
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
                        startDestination = startDestination
                    )
                }
            }
        }
    }
}
