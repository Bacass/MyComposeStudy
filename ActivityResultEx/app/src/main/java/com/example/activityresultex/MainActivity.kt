package com.example.activityresultex

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activityresultex.ui.theme.ActivityResultExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ActivityResultExTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var userName by remember {
        mutableStateOf("")
    }

    var userAge by remember {
        mutableStateOf("")
    }

    // 액티비티 복귀시 처리
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // 넘어온 값이 RESULT_OK 이면 getStringExtra로 값을 꺼낸다.
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            userName = data?.getStringExtra("NAME") ?: ""
            userAge = data?.getStringExtra("AGE") ?: ""
        }
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "유저 이름은? ${userName.ifBlank { "빈값" }}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = "유저 나이는? ${userAge.ifBlank { "빈값" }}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(10.dp))
        Spacer(
            Modifier
                .height(1.dp)
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .background(Color.LightGray)
        )
        Spacer(Modifier.height(10.dp))
        Button(
            onClick = {
                // 위에서 만든 launcher를 이용해 실행할 Intent를 만든다.
                launcher.launch(Intent(context, SecondActivity::class.java))
            }
        ) {
            Text(
                text = "SecondActivity로 이동"
            )
        }
    }
}

























