package com.example.mycomposeexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import com.example.mycomposeexam.ui.theme.MyComposeExamTheme
import kotlin.math.roundToInt

class LayoutModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MyComposeExamTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    private fun MainScreen() {
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.size(120.dp, 80.dp)) {
            Column {
                ColorBoxW(
                    Modifier.exampleLayoutW(0f).background(Color.Blue)
                )
                ColorBoxW(
                    Modifier.exampleLayoutW(0.25f).background(Color.Green)
                )
                ColorBoxW(
                    Modifier.exampleLayoutW(0.5f).background(Color.Yellow)
                )
                ColorBoxW(
                    Modifier.exampleLayoutW(0.25f).background(Color.Red)
                )
                ColorBoxW(
                    Modifier.exampleLayoutW(0.0f).background(Color.Magenta)
                )
                Spacer(Modifier.size(50.dp))
                Row {
                    ColorBoxH(
                        Modifier.exampleLayoutH(0.0f).background(Color.Blue)
                    )
                    ColorBoxH(
                        Modifier.exampleLayoutH(0.25f).background(Color.Green)
                    )
                    ColorBoxH(
                        Modifier.exampleLayoutH(0.5f).background(Color.Red)
                    )
                    ColorBoxH(
                        Modifier.exampleLayoutH(0.25f).background(Color.Yellow)
                    )
                    ColorBoxH(
                        Modifier.exampleLayoutH(0.0f).background(Color.Magenta)
                    )
                }
            }
        }
    }

    fun Modifier.exampleLayoutW(
        fraction: Float
    ) = layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        val x = -(placeable.width * fraction).roundToInt()

        layout(placeable.width, placeable.height) {
            placeable.placeRelative(x = x, y = 0)
        }
    }

    fun Modifier.exampleLayoutH(
        fraction: Float
    ) = layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)

        val y = -(placeable.height * fraction).roundToInt()

        layout(placeable.width, placeable.height) {
            placeable.placeRelative(x = 0, y = y)
        }
    }

    @Composable
    fun ColorBoxW(modifier: Modifier) {
        Box(Modifier
            .padding(1.dp)
            .size(width = 50.dp, height = 10.dp)
            .then(modifier))
    }

    @Composable
    fun ColorBoxH(modifier: Modifier) {
        Box(Modifier
            .padding(1.dp)
            .size(width = 10.dp, height = 50.dp)
            .then(modifier))
    }
}