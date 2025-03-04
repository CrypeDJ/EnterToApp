package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.crype.entertoapp.core.common.CountryCodes
import com.crype.entertoapp.presentation.ui.theme.ActiveBlue
import com.crype.entertoapp.presentation.ui.theme.DescriptionText
import com.crype.entertoapp.presentation.ui.theme.ItemCountry
import com.crype.entertoapp.presentation.ui.theme.Roboto
import com.crype.entertoapp.presentation.ui.theme.TitleText

@Composable
fun ChooseCountryItem(
    isChosen: Boolean,
    country: CountryCodes,
    flagIconPadding: Dp,
    flagIconSize: Dp,
    checkMarkSize: Dp,
    checkMarkHorizontalPadding: Dp,
    countryFontSize: TextUnit,
    countryFontWeight: FontWeight,
    codeFontSize: TextUnit,
    codeFontWeight: FontWeight,
    countryInfoVerticalPadding: Dp,
    countryInfoHorizontalPadding: Dp,

    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White,
            disabledContainerColor = ItemCountry
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = country.flag),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(flagIconPadding)
                        .size(flagIconSize)
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(
                            vertical = countryInfoVerticalPadding,
                            horizontal = countryInfoHorizontalPadding
                        )
                ) {
                    Text(
                        text = country.countryName,
                        fontFamily = Roboto,
                        fontWeight = countryFontWeight,
                        fontSize = countryFontSize,
                        color = TitleText
                    )
                    Text(
                        text = country.codeString,
                        fontFamily = Roboto,
                        fontSize = codeFontSize,
                        fontWeight = codeFontWeight,
                        color = DescriptionText
                    )
                }
            }
            if (isChosen) {
                Box(modifier = Modifier.padding(horizontal = checkMarkHorizontalPadding)) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = ActiveBlue,
                        modifier = Modifier
                            .size(checkMarkSize)
                    )
                }
            }
        }
    }
}