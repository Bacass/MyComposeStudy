package com.lee.flashlight

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lee.flashlight.ui.theme.FlashLightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashLightTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    private fun MainScreen(modifier: Modifier = Modifier) {
        val flash = rememberSaveable {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("플래시 ON/OFF")
                Spacer(modifier = Modifier.size(6.dp))
                Switch(
                    checked = flash.value,
                    onCheckedChange = { checked ->
                        flash.value = checked
                        Toast.makeText(this@MainActivity, "Flash:$checked", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }

            Spacer(modifier = Modifier.size(10.dp))

            Card(modifier = Modifier.size(100.dp)) {
                if (flash.value) {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color.Yellow)
                    )
                } else {
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color.Gray)
                    )
                }
            }
        }

    }
}