package com.example.mycomposeexam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeexam.ui.theme.MyComposeExamTheme

class MainActivity : ComponentActivity() {
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
}

interface OnClickButtonListener {
    fun onClick()
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Center) {
        SetText("BoxLayout", object : OnClickButtonListener {
            override fun onClick() {
                context.startActivity(Intent(context, BoxLayoutActivity::class.java))
            }
        })

        SetText("Slider", object : OnClickButtonListener {
            override fun onClick() {
                context.startActivity(Intent(context, SliderActivity::class.java))
            }
        })

        SetText("IntrinsicSize", object : OnClickButtonListener {
            override fun onClick() {
                context.startActivity(Intent(context, IntrinsicSizeActivity::class.java))
            }
        })

        SetText("LayoutModifier", object : OnClickButtonListener {
            override fun onClick() {
                context.startActivity(Intent(context, LayoutModifierActivity::class.java))
            }
        })

        SetText("Modifier", object : OnClickButtonListener {
            override fun onClick() {
                context.startActivity(Intent(context, ModifierActivity::class.java))
            }
        })
    }
}

@Composable
private fun SetText(txt: String, onClickListener: OnClickButtonListener) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable {
                onClickListener.onClick()
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            contentAlignment = Alignment.CenterStart // Box의 내용을 중앙 정렬
        ) {
            Text(
                txt,
                Modifier.padding(start = 20.dp),
                fontSize = 22.sp
            )
        }
    }

    Spacer(
        Modifier
            .fillMaxWidth()
            .height(12.dp)
    )
}

