package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.crype.entertoapp.presentation.ui.theme.Roboto
import com.crype.entertoapp.presentation.ui.theme.TitleText

@Composable
fun CodeBlock(
    isFocused: Boolean,
    blockWidth: Dp,
    blockHeight: Dp,
    fontSize: TextUnit,
    activeColor: Color,
    nonActiveColor: Color,
    value: String,
    focusRequester: FocusRequester,
    onValueChange: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(
                color = if (isFocused) activeColor else nonActiveColor,
                shape = RoundedCornerShape(10.dp)
            )
            .size(width = blockWidth, height = blockHeight)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            cursorBrush = SolidColor(Color.Transparent),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = fontSize,
                fontFamily = Roboto,
                color = TitleText,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .focusRequester(focusRequester)
        )
    }
}