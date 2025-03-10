package com.crype.entertoapp.presentation.navigation

sealed class Screens(val route: String) {
    object EnterNumberScreen: Screens(route = "enter_number")
    object ChooseCountryScreen: Screens(route = "choose_country")
    object EnterCodeScreen: Screens(route = "enter_code")
    object EmptyScreen: Screens(route = "empty")
}