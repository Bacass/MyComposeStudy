package com.example.bottomnavigation

sealed class BottomNavigationRoute(val route: String) {
    object HomeRoute : BottomNavigationRoute("Home")
    object SettingsRoute : BottomNavigationRoute("Settings")
    object FavoritesRoute : BottomNavigationRoute("Favorites")
}