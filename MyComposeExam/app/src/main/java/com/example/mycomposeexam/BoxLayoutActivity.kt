package com.example.mycomposeexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeexam.ui.theme.MyComposeExamTheme

class BoxLayoutActivity : ComponentActivity() {
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
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .size(height = 150.dp, width = 290.dp)
                .padding(vertical = 80.dp, horizontal = 40.dp)
        ) {
            Text("TopStart", Modifier.align(Alignment.TopStart))
            Text("TopCenter", Modifier.align(Alignment.TopCenter))
            Text("TopEnd", Modifier.align(Alignment.TopEnd))

            Text("CenterStart", Modifier.align(Alignment.CenterStart))
//            Text("Center", Modifier.align(Alignment.Center))
            Text("CenterEnd", Modifier.align(Alignment.CenterEnd))

            Text("BottomStart", Modifier.align(Alignment.BottomStart))
            Text("BottomCenter", Modifier.align(Alignment.BottomCenter))
            Text("BottomEnd", Modifier.align(Alignment.BottomEnd))

            TextCell("TextCell", Modifier.align(Alignment.Center), 14)
        }
    }

    @Composable
    private fun TextCell(text: String, modifier: Modifier = Modifier, fontSize: Int = 150) {
        val cellModifier = Modifier
            .padding(4.dp)
            .border(width = 5.dp, color = Color.White)

        Text(
            text = text,
            cellModifier.then(modifier).background(Color.Green),
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}

