package com.crype.entertoapp.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.crype.entertoapp.presentation.screen.ChooseCountryScreen
import com.crype.entertoapp.presentation.screen.EmptyScreen
import com.crype.entertoapp.presentation.screen.EnterCodeScreen
import com.crype.entertoapp.presentation.screen.EnterNumberScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screens.EnterNumberScreen.route) {
            EnterNumberScreen(navController)
        }
        composable(route = Screens.ChooseCountryScreen.route) {
            ChooseCountryScreen(navController)
        }
        composable(route = Screens.EnterCodeScreen.route) {
            EnterCodeScreen(navController)
        }
        composable(route = Screens.EmptyScreen.route) {
            EmptyScreen()
        }
    }
}
