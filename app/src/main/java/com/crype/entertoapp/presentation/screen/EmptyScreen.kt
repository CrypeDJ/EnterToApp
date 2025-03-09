package com.crype.entertoapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.crype.entertoapp.presentation.viewmodel.EnterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EmptyScreen(
    viewModel: EnterViewModel = koinViewModel()
){
    val userInfo by remember {
        mutableStateOf(viewModel.getUserInfo())
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Phone number: ${userInfo.phoneNumber}\nUser ID: ${userInfo.userID}"
        )
    }
}