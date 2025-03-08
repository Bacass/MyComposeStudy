package com.example.bottomnavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomRouteData(
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val route: String
)