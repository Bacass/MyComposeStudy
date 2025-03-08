package com.example.designex02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigation.BottomNavigationRoute
import com.example.bottomnavigation.BottomRouteData
import com.example.designex02.ui.theme.DesignEx02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val items = remember {
        getBottomRouteDataList()
    }

    val navController = rememberNavController()
    val navBackStackEntry: NavBackStackEntry? by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFEAF2FA)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = BottomNavigationRoute.HomeRoute.route
            ) {
                composable(BottomNavigationRoute.HomeRoute.route) {
                    ScreenHome()
                }
                composable(BottomNavigationRoute.ExploreRoute.route) {
                    ScreenExplore()
                }
                composable(BottomNavigationRoute.BookingsRoute.route) {
                    ScreenBookings()
                }
                composable(BottomNavigationRoute.ProfileRoute.route) {
                    ScreenProfile()
                }
            }

            Row(
                modifier = Modifier
                    .height(80.dp)
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(Color.White),
            ) {
                items.forEach { item: BottomRouteData ->
                    val selected = item.route == currentDestination?.route

                    NavigationBarItem(
                        selected = selected,
                        icon = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = if (selected) item.iconSelected else item.iconUnselected,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                                Text(item.route, color = Color.Black, fontSize = 12.sp)
                            }
                        },
                        onClick = {
                            currentDestination?.hierarchy?.forEach { destination ->
                                println("destination : $destination")
                            }

                            navController.navigate(route = item.route)
                        },
                    )
                }
            }
        }
    }
//    }
}

@Composable
private fun ScreenHome() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFEAF2FA)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFF161E49))
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.baseline_location_on_24),
                                modifier = Modifier.size(20.dp),
                                contentDescription = null
                            )
                            Text(
                                "Location",
                                modifier = Modifier.padding(start = 2.dp),
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "Dhaka, Bangladesh",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Spacer(Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .size(60.dp) // 크기 설정
                            .clip(CircleShape) // 원형으로 자르기
                            .border(1.dp, Color(0xED494848), CircleShape) // 테두리 추가
                            .background(Color.Transparent), // 배경 색상 (선택 사항)
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painterResource(R.drawable.baseline_add_alert_24),
                            modifier = Modifier.size(30.dp),
                            contentDescription = null
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(430.dp)
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFEAF2FA))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                            .background(Color(0xFF161E49))
                    )

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color.White)
                    ) {
                        Column {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .weight(1f)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFF3751E3)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("One-way", fontSize = 14.sp, color = Color.White)
                                }
                                Spacer(Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .weight(1f)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFFEAF2FA)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Round trip", fontSize = 14.sp, color = Color.Black)
                                }
                                Spacer(Modifier.width(10.dp))
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(40.dp)
                                        .weight(1f)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFFEAF2FA)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("Multi-city", fontSize = 14.sp, color = Color.Black)
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                            ) {
                                Column {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clip(RoundedCornerShape(20.dp))
                                            .background(Color(0xFFEAF2FA)),
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(start = 20.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column {
                                                Image(
                                                    painter = painterResource(R.drawable.baseline_flight_takeoff_24),
                                                    modifier = Modifier.size(20.dp),
                                                    contentDescription = null
                                                )
                                                Text(
                                                    "DXB",
                                                    modifier = Modifier.width(45.dp),
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                            }
                                            Spacer(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                                    .padding(
                                                        start = 10.dp,
                                                        top = 10.dp,
                                                        bottom = 10.dp
                                                    )
                                                    .width(1.dp)
                                                    .background(Color.Gray)
                                                    .alpha(0.4f)
                                            )
                                            Column(
                                                modifier = Modifier.padding(start = 10.dp)
                                            ) {
                                                Text(
                                                    "From",
                                                    fontSize = 16.sp,
                                                    color = Color.DarkGray
                                                )
                                                Text(
                                                    "Dubai, UAE",
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                            }
                                        }
                                    }
                                    Spacer(Modifier.height(10.dp))
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(60.dp)
                                            .clip(RoundedCornerShape(20.dp))
                                            .background(Color(0xFFEAF2FA)),
                                    ) {
                                        Row(
                                            modifier = Modifier.padding(start = 20.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column {
                                                Image(
                                                    painter = painterResource(R.drawable.baseline_flight_land_24),
                                                    modifier = Modifier.size(20.dp),
                                                    contentDescription = null
                                                )
                                                Text(
                                                    "ICN",
                                                    modifier = Modifier.width(45.dp),
                                                    fontSize = 20.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                            }
                                            Spacer(
                                                modifier = Modifier
                                                    .fillMaxHeight()
                                                    .padding(
                                                        start = 10.dp,
                                                        top = 10.dp,
                                                        bottom = 10.dp
                                                    )
                                                    .width(1.dp)
                                                    .background(Color.Gray)
                                                    .alpha(0.4f)
                                            )
                                            Column(
                                                modifier = Modifier.padding(start = 10.dp)
                                            ) {
                                                Text(
                                                    "To",
                                                    fontSize = 16.sp,
                                                    color = Color.DarkGray
                                                )
                                                Text(
                                                    "Incheon, S.Korea",
                                                    fontSize = 16.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black
                                                )
                                            }
                                        }
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .align(Alignment.CenterEnd)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF3751E3)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painterResource(R.drawable.baseline_published_with_changes_24),
                                            modifier = Modifier.size(22.dp),
                                            contentDescription = null
                                        )
                                    }
                                }
                            }

                            Spacer(Modifier.height(10.dp))

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(horizontal = 20.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xFFEAF2FA)),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                Column(
                                    modifier = Modifier.padding(start = 20.dp)
                                ) {
                                    Text(
                                        "Departure",
                                        fontSize = 16.sp,
                                        color = Color.DarkGray
                                    )
                                    Text(
                                        "Thu, 28 Mar 2025",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                }
                            }

                            Spacer(Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(horizontal = 20.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                        .weight(1f)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFFEAF2FA)),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Column(
                                        modifier = Modifier.padding(start = 20.dp)
                                    ) {
                                        Text(
                                            "Passengers",
                                            fontSize = 16.sp,
                                            color = Color.DarkGray
                                        )
                                        Text(
                                            "1Adult",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    }
                                }

                                Spacer(Modifier.width(10.dp))

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                        .weight(1f)
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(Color(0xFFEAF2FA)),
                                    contentAlignment = Alignment.CenterStart
                                ) {
                                    Column(
                                        modifier = Modifier.padding(start = 20.dp)
                                    ) {
                                        Text(
                                            "Class",
                                            fontSize = 16.sp,
                                            color = Color.DarkGray
                                        )
                                        Text(
                                            "Economy",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.Black
                                        )
                                    }
                                }
                            }

                            Spacer(Modifier.height(10.dp))

                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .padding(horizontal = 20.dp)
                                    .clip(RoundedCornerShape(20.dp)),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF3751E3)
                                ),
                                onClick = {
                                }
                            ) {
                                Text(
                                    "Search flights",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFEAF2FA))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 100.dp)
                        .clip(RoundedCornerShape(20.dp))
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painterResource(R.drawable.img_event01),
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                        Image(
                            painterResource(R.drawable.img_event02),
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentScale = ContentScale.Crop,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ScreenExplore() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFFF0000)
    ) {
        Text("ScreenExplore")
    }
}

@Composable
private fun ScreenBookings() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFFFFFCC)
    ) {
        Text("ScreenBookings")
    }
}

@Composable
private fun ScreenProfile() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFEAF2FA)
    ) {
        Text("ScreenProfile")
    }
}

fun getBottomRouteDataList() = listOf(
    BottomRouteData(
        title = "Home",
        iconSelected = Icons.Filled.Home,
        iconUnselected = Icons.Outlined.Home,
        route = BottomNavigationRoute.HomeRoute.route
    ),
    BottomRouteData(
        title = "Explore",
        iconSelected = Icons.Filled.Search,
        iconUnselected = Icons.Outlined.Search,
        route = BottomNavigationRoute.ExploreRoute.route
    ),
    BottomRouteData(
        title = "Bookings",
        iconSelected = Icons.Filled.Favorite,
        iconUnselected = Icons.Outlined.FavoriteBorder,
        route = BottomNavigationRoute.BookingsRoute.route
    ),
    BottomRouteData(
        title = "Profile",
        iconSelected = Icons.Filled.Person,
        iconUnselected = Icons.Outlined.Person,
        route = BottomNavigationRoute.ProfileRoute.route
    )
)


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignEx02Theme {
        MainScreen()
    }
}