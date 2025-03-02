package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.crype.entertoapp.domain.model.CountryCodeModel
import com.crype.entertoapp.presentation.ui.theme.BackgroundEnterField
import com.crype.entertoapp.presentation.ui.theme.Roboto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryNumberCode(
    horizontalPadding: Dp,
    height: Dp,
    country: CountryCodeModel,
    spaceBetween: Dp,
    codeSize: TextUnit,
    iconSize: Dp,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors().copy(
            containerColor = BackgroundEnterField
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = horizontalPadding,
                )
                .height(height),
            horizontalArrangement = Arrangement.spacedBy(spaceBetween),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(country.flag),
                contentDescription = "flag",
                modifier = Modifier
                    .size(iconSize),
            )
            Text(
                text = country.codeString,
                fontSize = codeSize,
                fontFamily = Roboto
            )
        }
    }
}