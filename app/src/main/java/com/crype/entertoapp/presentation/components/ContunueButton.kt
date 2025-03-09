package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ContinueButton(
    onClick: () -> Unit,
    isActive: Boolean,
    disableColor: Color,
    activeColor: Color,
    height: Dp,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    text: String
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        colors = ButtonDefaults.buttonColors().copy(
            contentColor = Color.White,
            containerColor = if (isActive) activeColor else disableColor
        ),
        shape = RoundedCornerShape(14.dp),
        enabled = isActive
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
        )
    }
}