package com.lee.lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lee.lazycolumn.ui.theme.LazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    val list: List<String> = List(60) { "$it" }

    Surface{
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 5.dp)
                .background(Color.Yellow),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(list) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(if (it.toInt() % 2 == 0) Color.DarkGray else Color.White),
                ) {
                    Text(
                        "$it 번",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        color = if (it.toInt() % 2 == 0) Color.White else Color.Black,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun ShowPreview() {
    MainScreen()
}