package com.example.swipedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipedemo.ui.theme.SwipeDemoTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwipeDemoTheme {
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val parentBoxWidth = 260.dp
    val childBoxSides = 60.dp

    val swipeableState = rememberSwipeableState("L")
    val widthPx = with(LocalDensity.current) {
        (parentBoxWidth - childBoxSides).toPx()
    }
    val anchors = mapOf(0f to "L", widthPx / 2 to "C", widthPx to "R")

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .width(parentBoxWidth)
                    .height(childBoxSides)
                    .swipeable(
                        state = swipeableState,
                        anchors = anchors,
                        thresholds = { _, _ -> FractionalThreshold(0.5f) },
                        orientation = Orientation.Horizontal
                    )
            ) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .height(5.dp)
                        .background(Color.White)
                        .align(Alignment.CenterStart)
                )

                Box(
                    Modifier
                        .size(10.dp)
                        .background(
                            Color.DarkGray,
                            shape = CircleShape
                        )
                        .align(Alignment.CenterStart)
                )

                Box(
                    Modifier
                        .size(10.dp)
                        .background(
                            Color.DarkGray,
                            shape = CircleShape
                        )
                        .align(Alignment.Center)
                )

                Box(
                    Modifier
                        .size(10.dp)
                        .background(
                            Color.DarkGray,
                            shape = CircleShape
                        )
                        .align(Alignment.CenterEnd)
                )

                Box(
                    Modifier
                        .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                        .size(childBoxSides)
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        swipeableState.currentValue,
                        color = Color.White,
                        fontSize = 26.sp
                    )
                }
            }
        }
    }
}





















