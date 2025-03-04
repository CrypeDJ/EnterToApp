package com.crype.entertoapp.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.entertoapp.R
import com.crype.entertoapp.core.common.CountryCodes
import com.crype.entertoapp.presentation.components.ContinueButton
import com.crype.entertoapp.presentation.components.CountryNumberCode
import com.crype.entertoapp.presentation.components.Description
import com.crype.entertoapp.presentation.components.EnterNumber
import com.crype.entertoapp.presentation.components.Title
import com.crype.entertoapp.presentation.ui.theme.ActiveBlue
import com.crype.entertoapp.presentation.ui.theme.DisableButton

@Composable
fun EnterNumberScreen(
    //navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
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
                country = CountryCodes.RUSSIA,
                spaceBetween = 10.dp,
                codeSize = 16.sp,
                iconSize = 24.dp
            ) {}
            EnterNumber(
                value = "",
                onValueChange = {},
                fontSize = 16.sp,
                height = 56.dp
            )
        }
        ContinueButton(
            onClick = { },
            isDisable = false,
            disableColor = DisableButton,
            activeColor = ActiveBlue,
            height = 56.dp,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            text = stringResource(id = R.string.enter_num_button)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EnterNumberScreenPreview() {
    EnterNumberScreen()
}