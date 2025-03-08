package com.example.designex03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.designex03.screen.ForgotPassword
import com.example.designex03.screen.Login
import com.example.designex03.screen.NewAccount
import com.example.designex03.ui.theme.DesignEx03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignEx03Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.NewAccount.route) {
        composable(route = NavRoutes.NewAccount.route) {
            NewAccount(navController = navController)
        }
        composable(route = NavRoutes.Login.route) {
            Login(navController = navController)
        }
        composable(route = NavRoutes.ForgotPassword.route) {
            ForgotPassword(navController = navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignEx03Theme {
        MainScreen()
    }
}