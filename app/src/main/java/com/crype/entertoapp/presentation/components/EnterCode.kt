package com.crype.entertoapp.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun EnterCode(
    code: List<String>,
    onCodeChange: (Int, String) -> Unit,
    blockWidth: Dp,
    blockHeight: Dp,
    fontSize: TextUnit,
    activeColor: Color,
    nonActiveColor: Color,
    spaceBetween: Dp
) {
    val codeLength = code.size
    val focusRequesters = List(codeLength) { FocusRequester() }

    Row(horizontalArrangement = Arrangement.spacedBy(spaceBetween)) {
        code.forEachIndexed { i, digit ->
            CodeBlock(
                isFocused = code[i].isEmpty() && (i == 0 || code[i - 1].isNotEmpty()),
                blockWidth = blockWidth,
                blockHeight = blockHeight,
                fontSize = fontSize,
                activeColor = activeColor,
                nonActiveColor = nonActiveColor,
                value = digit,
                focusRequester = focusRequesters[i],
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        onCodeChange(i, newValue)
                        when {
                            newValue.isNotEmpty() && i < codeLength - 1 -> focusRequesters[i + 1].requestFocus()
                            newValue.isEmpty() && i > 0 -> {
                                focusRequesters[i - 1].requestFocus()
                            }
                        }
                    }
                }
            )
        }
    }
}
