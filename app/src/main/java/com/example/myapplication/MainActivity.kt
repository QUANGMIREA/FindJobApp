package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.CandyPhoto.CandyCollectionScreen
import com.example.myapplication.LoginScreen.Login
import com.example.myapplication.LoginScreen.Register
import com.example.myapplication.SplashScreen.SplashScreen
import com.example.myapplication.homescreen.HomeScreen
import com.example.myapplication.presentation.onboarding.OnBoardingScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Box(modifier = Modifier.background(color = Color.White)){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "SplashScreen", builder = {
                        composable("Login"){
                            Login(navController)
                        }
                        composable("OnBoardingScreen"){
                            OnBoardingScreen(navController)
                        }
                        composable("Register"){
                            Register(navController)
                        }
                        composable("HomeScreen"){
                            HomeScreen(navController)
                        }
                        composable("SplashScreen"){
                            SplashScreen(navController)
                        }
                        composable("CandyPhoto"){
                            CandyCollectionScreen(navController)
                        }


                    })
                }
            }
        }
    }
}

