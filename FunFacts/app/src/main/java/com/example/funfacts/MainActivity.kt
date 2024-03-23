package com.example.funfacts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.funfacts.ui.theme.FunFactsTheme
import com.example.funfacts.ui.theme.screens.NavigationGraph
import com.example.funfacts.ui.theme.screens.Routes
import com.example.funfacts.ui.theme.screens.UserInput
import com.example.funfacts.ui.theme.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunFactsTheme {
                // A surface container using the 'background' color from the theme
                    FunFactsApp()
            }
        }
    }
}


@Composable
fun FunFactsApp(){
    NavigationGraph()
}
