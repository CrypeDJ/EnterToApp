package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.crype.entertoapp.R
import com.crype.entertoapp.presentation.ui.theme.BackgroundEnterField
import com.crype.entertoapp.presentation.ui.theme.DescriptionText
import com.crype.entertoapp.presentation.ui.theme.Roboto
import org.w3c.dom.Text

@Composable
fun EnterNumber(
    value: String,
    onValueChange:(String)-> Unit,
    fontSize: TextUnit,
    height: Dp,
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = BackgroundEnterField,
            unfocusedContainerColor = BackgroundEnterField,
            unfocusedPlaceholderColor = DescriptionText,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = Roboto,
            fontSize = fontSize,
            textAlign = TextAlign.Start,
        ),
        modifier = Modifier
            .height(height),
        placeholder = {
            Text(
                text = stringResource(id = R.string.enter_num_hint),
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}