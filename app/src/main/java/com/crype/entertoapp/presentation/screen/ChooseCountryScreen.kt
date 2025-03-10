package com.crype.entertoapp.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crype.entertoapp.R
import com.crype.entertoapp.core.common.CountryCodes
import com.crype.entertoapp.presentation.components.ChooseCountryItem
import com.crype.entertoapp.presentation.components.Title
import com.crype.entertoapp.presentation.navigation.Screens
import com.crype.entertoapp.presentation.ui.theme.Border
import com.crype.entertoapp.presentation.viewmodel.EnterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseCountryScreen(
    navController: NavController,
    viewModel: EnterViewModel = koinViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Title(
            text = stringResource(id = R.string.choose_country_title),
            fontSize = 32.sp,
            topPadding = 5.dp,
            bottomPadding = 16.dp,
            letterSpacing = 0.sp
        )
        Card(
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Border
            ),
            colors = CardDefaults.cardColors().copy(
                containerColor = Color.White
            )
        ) {
            LazyColumn(
                contentPadding = PaddingValues(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(CountryCodes.entries) { index, country ->
                    ChooseCountryItem(
                        isChosen = viewModel.countryCode.value == country,
                        country = country,
                        flagIconPadding = 12.dp,
                        flagIconSize = 46.dp,
                        checkMarkSize = 34.dp,
                        checkMarkHorizontalPadding = 12.dp,
                        countryFontSize = 18.sp,
                        countryFontWeight = FontWeight.Medium,
                        codeFontSize = 16.sp,
                        codeFontWeight = FontWeight.Normal,
                        countryInfoVerticalPadding = 0.dp,
                        countryInfoHorizontalPadding = 3.dp
                    ) {
                        viewModel.chooseCountry(country)
                        navController.navigate(route = Screens.EnterNumberScreen.route)
                    }
                }
            }
        }
    }
}