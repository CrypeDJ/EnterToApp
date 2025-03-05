package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.crype.entertoapp.presentation.ui.theme.Roboto

@Composable
fun ResendCodeButton(
    isClickable: Boolean,
    clickableColor: Color,
    nonClickableColor: Color,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    clickableText: String,
    nonClickableText: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isClickable) clickableText else nonClickableText,
            fontSize = fontSize,
            fontFamily = Roboto,
            fontWeight = fontWeight,
            color = if (isClickable) clickableColor else nonClickableColor,
            modifier = Modifier
                .clickable {
                    if (isClickable) onClick()
                }
        )
    }
}