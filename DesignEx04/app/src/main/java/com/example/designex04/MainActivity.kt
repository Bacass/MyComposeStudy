package com.example.designex04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designex04.ui.theme.DesignEx04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignEx04Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val (name, setName) = remember {
        mutableStateOf("")
    }
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(R.drawable.background),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth,
            contentDescription = "background"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            /**
             * 타이틀 부분
             */
            Text(
                "Create New\nAccount",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 34.sp,
                textAlign = TextAlign.Center
            )
            Text(
                "Already Registered? Log in here",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 12.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(50.dp))
            /**
             * 입력창 부분
             */
            Text(
                "NAME",
                modifier = Modifier.padding(start = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffa3a7a6)
            )
            Spacer(Modifier.height(6.dp))
            TextField(
                onValueChange = { it ->
                    setName(it)
                },
                value = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xffa3a7a6),
                    unfocusedContainerColor = Color(0xffa3a7a6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(Color.White, fontSize = 16.sp)
            )

            Spacer(Modifier.height(10.dp))
            Text(
                "EMAIL",
                modifier = Modifier.padding(start = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffa3a7a6)
            )
            Spacer(Modifier.height(6.dp))
            TextField(
                onValueChange = { it ->
                    setEmail(it)
                },
                value = email,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xffa3a7a6),
                    unfocusedContainerColor = Color(0xffa3a7a6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(Color.White, fontSize = 16.sp)
            )

            Spacer(Modifier.height(10.dp))
            Text(
                "PASSWORD",
                modifier = Modifier.padding(start = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xffa3a7a6)
            )
            Spacer(Modifier.height(6.dp))
            TextField(
                onValueChange = { it ->
                    setPassword(it)
                },
                value = password,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xffa3a7a6),
                    unfocusedContainerColor = Color(0xffa3a7a6),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(Color.White, fontSize = 16.sp),
                visualTransformation = PasswordVisualTransformation(), // 비밀번호 숨기기
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            /**
             * sign up 버튼
             */
            Spacer(Modifier.height(30.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16.dp), // 네모 모양 설정
                onClick = {
                }
            ) {
                Row {
                    Image(
                        painter = painterResource(R.drawable.baseline_login_24),
                        contentDescription = "login"
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "sign up",
                        modifier = Modifier.padding(top = 1.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignEx04Theme {
        MainScreen()
    }
}