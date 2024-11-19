package com.example.lab14

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab14.ui.theme.Lab14Theme
import com.google.ai.client.generativeai.type.content

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val destination = intent.getStringExtra("destination") ?: "primary"
        setContent {
            val navController = rememberNavController()
            Lab14Theme {
                Navigate(navController = navController, startDestination = destination)
            }
        }
    }
}

@Composable
fun Navigate (navController:NavHostController, startDestination: String){
    Scaffold(
        topBar = {TopBar(navController)},
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            NavHost(
                navController = navController,
                startDestination = startDestination
            ) {
                composable("primary") {
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(padding)
                    )
                }
                composable("second") { secondView(modifier = Modifier.padding(padding)) }
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab14Theme {
        Greeting("Android")
    }
}