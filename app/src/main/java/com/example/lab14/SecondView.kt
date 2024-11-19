package com.example.lab14

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun secondView(modifier : Modifier = Modifier) {
    Text(
        text = "pagina secundaria",
        modifier = modifier
    )
}