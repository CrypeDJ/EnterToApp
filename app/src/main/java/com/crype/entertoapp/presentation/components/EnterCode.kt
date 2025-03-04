package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun EnterCode(
    code: MutableList<String>,
    blockWidth: Dp,
    blockHeight: Dp,
    fontSize: TextUnit,
    activeColor: Color,
    nonActiveColor: Color,
    spaceBetween: Dp
) {
    val codeLength = code.size

    Row(
        horizontalArrangement = Arrangement.spacedBy(spaceBetween),
    ) {
        val focusRequester = List(code.size) { FocusRequester() }
        code.forEachIndexed { i, digit ->
            CodeBlock(
                isFocused = if (i == 0) true else code[i - 1].isNotEmpty(),
                blockWidth = blockWidth,
                blockHeight = blockHeight,
                fontSize = fontSize,
                activeColor = activeColor,
                nonActiveColor = nonActiveColor,
                value = digit,
                focusRequester = focusRequester[i],
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        code[i] = newValue
                        if (newValue.isNotEmpty() && i < codeLength - 1) {
                            focusRequester[i + 1].requestFocus()
                        } else if (newValue.isEmpty() && i > 0) {
                            focusRequester[i - 1].requestFocus()
                        }
                    }
                }
            )
        }
    }
}