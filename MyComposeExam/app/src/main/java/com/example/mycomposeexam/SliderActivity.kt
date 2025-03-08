package com.example.mycomposeexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeexam.ui.theme.MyComposeExamTheme

class SliderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MyComposeExamTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    private fun MainScreen() {
        var sliderPosition by remember {
            mutableStateOf(20f)
        }

        val handlePositionChange = { position : Float ->
            sliderPosition = position
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Surface(
                modifier = Modifier.height(50.dp)
            ) {
                DemoText(message = "Welcome to Compose", fontSize = sliderPosition)
            }

            Spacer(modifier = Modifier.height(100.dp))

            DemoSlider(
                sliderPosition = sliderPosition,
                onPositionChange = handlePositionChange
            )

            Text(
                style = MaterialTheme.typography.headlineSmall,
                text = sliderPosition.toInt().toString() + "sp"
            )
        }
    }

    @Composable
    private fun DemoText(message: String, fontSize: Float) {
        Text(
            text = message,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit) {
        Slider(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 80.dp),
            valueRange = 20f..35f,
            value = sliderPosition,
            onValueChange = onPositionChange
        )
    }
}