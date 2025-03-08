package com.example.designex03.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.designex03.NavRoutes

@Composable
fun Login(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                DrawLoginTitle()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                DrawLoginInput(navController)
            }
        }
    }
}

@Composable
fun DrawLoginTitle() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            "Login",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Text(
            "Sign in to continue.",
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(30.dp))
    }
}

@Composable
fun DrawLoginInput(navController: NavController) {
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(8.dp))
        Text("EMAIL", fontSize = 14.sp, color = Color.Black)
        OutlinedTextField(
            onValueChange = { it ->
                setEmail(it)
            },
            value = email,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RectangleShape, // 네모 모양 설정
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            textStyle = TextStyle(Color.Black),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(Modifier.height(8.dp))
        Text("PASSWORD", fontSize = 14.sp, color = Color.Black)
        OutlinedTextField(
            onValueChange = { it ->
                setPassword(it)
            },
            value = password,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RectangleShape, // 네모 모양 설정
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            textStyle = TextStyle(Color.Black),
            visualTransformation = PasswordVisualTransformation(), // 비밀번호 숨기기
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(Modifier.height(40.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RectangleShape, // 네모 모양 설정
            onClick = {
                navController.navigate(NavRoutes.ForgotPassword.route)
            }
        ) {
            Text("log in", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}



















