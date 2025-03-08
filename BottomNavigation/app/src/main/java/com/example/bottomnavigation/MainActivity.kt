package com.example.bottomnavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.Home
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val items = remember {
        bottomRouteDataList()
    }

    val navController = rememberNavController()
    val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.height(56.dp),
                tonalElevation = 4.dp
            ) {
                items.forEach { item: BottomRouteData ->
                    val selected = item.route == currentDestination?.route

                    NavigationBarItem(
                        selected = selected,
                        icon = {
                            Icon(
                                imageVector = if (selected) item.iconSelected else item.iconUnselected,
                                contentDescription = null
                            )
                        },
                        onClick = {
                            currentDestination?.hierarchy?.forEach { destination ->
                                println("destination : $destination")
                            }

                            navController.navigate(route = item.route)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = BottomNavigationRoute.HomeRoute.route
        ) {
            composable(BottomNavigationRoute.HomeRoute.route) {
                ScreenHome()
            }

            composable(BottomNavigationRoute.SettingsRoute.route) {
                ScreenSettings()
            }

            composable(BottomNavigationRoute.FavoritesRoute.route) {
                ScreenFavorites()
            }
        }
    }
}

@Composable
private fun ScreenHome() {
    Text("ScreenHome")
}

@Composable
private fun ScreenSettings() {
    Text("ScreenSettings")
}

@Composable
private fun ScreenFavorites() {
    Text("ScreenFavorites")
}


fun bottomRouteDataList() = listOf(
    BottomRouteData(
        title = "Home",
        iconSelected = Icons.Filled.Home,
        iconUnselected = Icons.Outlined.Home,
        route = BottomNavigationRoute.HomeRoute.route
    ),
    BottomRouteData(
        title = "Settings",
        iconSelected = Icons.Filled.Settings,
        iconUnselected = Icons.Outlined.Settings,
        route = BottomNavigationRoute.SettingsRoute.route
    ),
    BottomRouteData(
        title = "Favorites",
        iconSelected = Icons.Filled.Favorite,
        iconUnselected = Icons.Outlined.FavoriteBorder,
        route = BottomNavigationRoute.FavoritesRoute.route
    )
)



