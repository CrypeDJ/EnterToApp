package com.crype.entertoapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.entertoapp.R
import com.crype.entertoapp.presentation.components.Description
import com.crype.entertoapp.presentation.components.EnterCode
import com.crype.entertoapp.presentation.components.ResendCodeButton
import com.crype.entertoapp.presentation.components.Title
import com.crype.entertoapp.presentation.ui.theme.ActiveBlock
import com.crype.entertoapp.presentation.ui.theme.ActiveBlue
import com.crype.entertoapp.presentation.ui.theme.BackgroundEnterField
import com.crype.entertoapp.presentation.ui.theme.TitleText

@Composable
fun EnterCodeScreen(
    //navController: NavController
) {
    val code = MutableList(6) { "" }
    val timer by remember {
        mutableStateOf("30")
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
            EnterCode(
                code = code,
                blockWidth = 36.dp,
                blockHeight = 44.dp,
                fontSize = 28.sp,
                activeColor = ActiveBlock,
                nonActiveColor = BackgroundEnterField,
                spaceBetween = 8.dp
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        ResendCodeButton(
            isClickable = true,
            clickableColor = ActiveBlue,
            nonClickableColor = TitleText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            clickableText = stringResource(id = R.string.button_resend_code),
            nonClickableText = stringResource(id = R.string.resend_code_timer) + timer
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnterCodePreview() {
    EnterCodeScreen()
}