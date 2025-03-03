package com.crype.entertoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crype.entertoapp.presentation.screen.EnterNumberScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screens.EnterNumberScreen.route){
            EnterNumberScreen()
        }
    }
}