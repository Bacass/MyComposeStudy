package com.example.designex03

sealed class NavRoutes(val route: String) {
    object NewAccount: NavRoutes("NewAccount")
    object Login: NavRoutes("Login")
    object ForgotPassword: NavRoutes("ForgotPassword")
}