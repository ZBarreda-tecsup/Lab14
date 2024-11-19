package com.example.lab14

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {navController.navigate("Primary")
            }) {
                Icon(imageVector = Icons.Outlined.KeyboardArrowLeft , contentDescription ="primary" )
            }
        },
        title ={ Text(text = "Widgets Page", color = Color.Black) },

        actions = {
            IconButton(onClick = {navController.navigate("second")
            }) {
                Icon(imageVector = Icons.Outlined.KeyboardArrowRight , contentDescription ="secondary" )
            }
        }

    )

}