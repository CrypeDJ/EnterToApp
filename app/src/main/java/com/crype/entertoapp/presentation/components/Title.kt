package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.crype.entertoapp.presentation.ui.theme.Roboto
import com.crype.entertoapp.presentation.ui.theme.TitleText
import org.w3c.dom.Text

@Composable
fun Title(
    text: String,
    fontSize: TextUnit,
    topPadding: Dp,
    bottomPadding: Dp,
    letterSpacing: TextUnit
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        color = TitleText,
        modifier = Modifier
            .padding(
                top = topPadding,
                bottom = bottomPadding
            ),
        letterSpacing = letterSpacing
    )
}