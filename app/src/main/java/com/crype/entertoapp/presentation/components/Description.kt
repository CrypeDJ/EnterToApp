package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.crype.entertoapp.presentation.ui.theme.DescriptionText

@Composable
fun Description(
    text: String,
    fontSize: TextUnit,
    topPadding: Dp,
    bottomPadding: Dp,
    lineHeight: TextUnit
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.Normal,
        color = DescriptionText,
        lineHeight = lineHeight,
        modifier = Modifier
            .padding(
                top = topPadding,
                bottom = bottomPadding
            )
    )
}