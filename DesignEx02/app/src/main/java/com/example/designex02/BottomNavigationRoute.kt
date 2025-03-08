package com.example.bottomnavigation

sealed class BottomNavigationRoute(val route: String) {
    object HomeRoute : BottomNavigationRoute("Home")
    object ExploreRoute : BottomNavigationRoute("Explore")
    object BookingsRoute : BottomNavigationRoute("Bookings")
    object ProfileRoute : BottomNavigationRoute("Profile")
}