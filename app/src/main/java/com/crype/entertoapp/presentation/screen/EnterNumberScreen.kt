package com.crype.entertoapp.presentation.screen

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.entertoapp.R
import com.crype.entertoapp.domain.model.AuthResult
import com.crype.entertoapp.presentation.components.ContinueButton
import com.crype.entertoapp.presentation.components.CountryNumberCode
import com.crype.entertoapp.presentation.components.Description
import com.crype.entertoapp.presentation.components.EnterNumber
import com.crype.entertoapp.presentation.components.ProgressBar
import com.crype.entertoapp.presentation.components.Title
import com.crype.entertoapp.presentation.navigation.Screens
import com.crype.entertoapp.presentation.ui.theme.ActiveBlue
import com.crype.entertoapp.presentation.ui.theme.DisableButton
import com.crype.entertoapp.presentation.viewmodel.EnterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EnterNumberScreen(
    navController: NavController,
    viewModel: EnterViewModel = koinViewModel()
) {
    val activity = getActivity() ?: return
    val authResult by viewModel.authResult

    LaunchedEffect(authResult) {
        viewModel.toggleProgressBar(false)
        authResult?.let {
            when (it) {
                is AuthResult.CodeSent -> navController.navigate(route = Screens.EnterCodeScreen.route)
                is AuthResult.Error -> {
                    Log.e("Error", it.message)
                    viewModel.toggleProgressBar(false)
                }

                else -> {}
            }
        }
    }
    Column {
        Title(
            text = stringResource(id = R.string.enter_num_title),
            fontSize = 32.sp,
            topPadding = 30.dp,
            bottomPadding = 15.dp,
            letterSpacing = 0.sp
        )
        Description(
            text = stringResource(id = R.string.enter_num_desc),
            fontSize = 14.sp,
            topPadding = 0.dp,
            bottomPadding = 45.dp,
            lineHeight = 20.sp
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            CountryNumberCode(
                horizontalPadding = 16.dp,
                height = 56.dp,
                country = viewModel.countryCode.value,
                spaceBetween = 10.dp,
                codeSize = 16.sp,
                iconSize = 24.dp
            ) {
                navController.navigate(route = Screens.ChooseCountryScreen.route)
            }
            EnterNumber(
                value = viewModel.phoneNumber.value,
                onValueChange = { newNumber ->
                    viewModel.validateEnterNumber(newNumber)
                },
                fontSize = 16.sp,
                height = 56.dp
            )
        }
        if (viewModel.inProgress.value) {
            ProgressBar()
        } else {
            ContinueButton(
                onClick = {
                    viewModel.toggleProgressBar(true)
                    viewModel.onContinueNumberButtonClick(activity)
                },
                isActive = viewModel.isActive.value,
                disableColor = DisableButton,
                activeColor = ActiveBlue,
                height = 56.dp,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                text = stringResource(id = R.string.enter_num_button)
            )
        }
    }

}

@Composable
fun getActivity(): Activity? {
    val context = LocalContext.current
    return context as? Activity
}
