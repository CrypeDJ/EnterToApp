package com.crype.entertoapp.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.entertoapp.R
import com.crype.entertoapp.domain.model.AuthResult
import com.crype.entertoapp.presentation.components.Description
import com.crype.entertoapp.presentation.components.EnterCode
import com.crype.entertoapp.presentation.components.ProgressBar
import com.crype.entertoapp.presentation.components.ResendCodeButton
import com.crype.entertoapp.presentation.components.Title
import com.crype.entertoapp.presentation.navigation.Screens
import com.crype.entertoapp.presentation.ui.theme.ActiveBlock
import com.crype.entertoapp.presentation.ui.theme.ActiveBlue
import com.crype.entertoapp.presentation.ui.theme.BackgroundEnterField
import com.crype.entertoapp.presentation.ui.theme.TitleText
import com.crype.entertoapp.presentation.viewmodel.EnterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EnterCodeScreen(
    navController: NavController,
    viewModel: EnterViewModel = koinViewModel()
) {
    val authResult by viewModel.authResult
    LaunchedEffect(authResult) {
        viewModel.toggleProgressBar(false)
        authResult?.let {
            when (it) {
                is AuthResult.Success -> navController.navigate(route = Screens.EmptyScreen.route) {
                    popUpTo(0) { inclusive = true }
                    launchSingleTop = true
                }

                is AuthResult.Error -> {
                    Log.e("Code send Error", it.message)
                    viewModel.toggleProgressBar(false)
                }

                else -> {}
            }
        }
    }

    Column {
        Title(
            text = stringResource(id = R.string.enter_code_title),
            fontSize = 32.sp,
            topPadding = 20.dp,
            bottomPadding = 8.dp,
            letterSpacing = 0.sp
        )
        Description(
            text = stringResource(id = R.string.enter_code_desc),
            fontSize = 14.sp,
            topPadding = 0.dp,
            bottomPadding = 45.dp,
            lineHeight = 20.sp
        )
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()
        ) {
            if (viewModel.inProgress.value) {
                ProgressBar()
            } else {
                EnterCode(
                    code = viewModel.code.value,
                    blockWidth = 36.dp,
                    blockHeight = 44.dp,
                    fontSize = 28.sp,
                    activeColor = ActiveBlock,
                    nonActiveColor = BackgroundEnterField,
                    spaceBetween = 8.dp,
                    onCodeChange = { i, value ->
                        viewModel.enterCodeNumber(i, value)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        ResendCodeButton(
            isClickable = viewModel.isResendCode.value,
            clickableColor = ActiveBlue,
            nonClickableColor = TitleText,
            fontSize = 16.sp,
            fontWeightClickable = FontWeight.Medium,
            fontWeightNonClickable = FontWeight.Normal,
            clickableText = stringResource(id = R.string.button_resend_code),
            nonClickableText = stringResource(id = R.string.resend_code_timer) + viewModel.formatTimer()
        ) {
            viewModel.timer()
        }
    }
}
