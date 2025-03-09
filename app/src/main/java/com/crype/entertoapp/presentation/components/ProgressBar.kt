package com.crype.entertoapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.crype.entertoapp.presentation.ui.theme.SemiTransparent

@Composable
fun ProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SemiTransparent),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}