package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.entertoapp.R
import com.crype.entertoapp.presentation.ui.theme.MainBackground
import com.crype.entertoapp.presentation.ui.theme.TitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .size(33.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    tint = TitleText,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(
            containerColor = MainBackground
        )
    )
}

@Preview
@Composable
fun lgjksdlkjg() {
    TopBar {

    }
}