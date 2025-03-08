package com.example.mycomposeexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mycomposeexam.ui.theme.MyComposeExamTheme

class IntrinsicSizeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MyComposeExamTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(start = 0.dp, top = 50.dp, end = 0.dp, bottom = 0.dp)
                        .background(Color.White)
                ) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    private fun MainScreen() {
        var textState by remember {
            mutableStateOf("")
        }

        val onTextChange = { text: String ->
            textState = text
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(5.dp)
                .background(Color.White)
        ) {
            Column(Modifier.width(IntrinsicSize.Min)) {
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = textState,
                    color = Color.Black
                )
                Box(
                    Modifier
                        .height(10.dp)
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(50.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                MyTextField(text = textState, onTextChange = onTextChange)
            }
        }
    }

    @Composable
    private fun MyTextField(text: String, onTextChange: (String) -> Unit) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            value = text,
            onValueChange = onTextChange
        )
    }
}