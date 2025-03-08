package com.example.designex03.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.designex03.NavRoutes
import com.example.designex03.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun NewAccount(navController: NavController) {
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
                DrawNewAccountTitle()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                DrawNewAccountInput(navController)
            }
        }
    }
}

@Composable
fun DrawNewAccountTitle() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            "Create New\nAccount",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        Text(
            "Already Registered? Log in here",
            fontSize = 16.sp,
            color = Color.Black
        )
        Spacer(Modifier.height(6.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawNewAccountInput(navController: NavController) {
    val (name, setName) = remember {
        mutableStateOf("")
    }
    val (email, setEmail) = remember {
        mutableStateOf("")
    }
    val (password, setPassword) = remember {
        mutableStateOf("")
    }
    val birthDay = remember {
        mutableStateOf("Select")
    }

    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(Modifier.height(8.dp))
        Text("NAME", fontSize = 14.sp, color = Color.Black)
        OutlinedTextField(
            onValueChange = { it ->
                setName(it)
            },
            value = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RectangleShape, // 네모 모양 설정
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            textStyle = TextStyle(Color.Black),
        )

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

        Spacer(Modifier.height(8.dp))
        Text("DATE OF BIRTH", fontSize = 14.sp, color = Color.Black)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(
                    border = BorderStroke(
                        width = 1.dp,
                        color = Color.Black
                    ),
                    shape = RectangleShape
                )
                .clickable {
                    showDatePicker = true
                }
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(Modifier.width(16.dp))
                Text(birthDay.value, fontSize = 16.sp, color = Color.Black)
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(R.drawable.baseline_calendar_today_24),
                    modifier = Modifier.size(24.dp),
                    contentDescription = "달력"
                )
                Spacer(Modifier.width(16.dp))
            }
        }

        Spacer(Modifier.height(20.dp))
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
                navController.navigate(NavRoutes.Login.route)
            }
        ) {
            Text("sign up", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                Button(onClick = {
                    selectedDate = datePickerState.selectedDateMillis
                    showDatePicker = false
                }) {
                    Text("확인")
                }
            },
            dismissButton = {
                Button(onClick = { showDatePicker = false }) {
                    Text("취소")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    selectedDate?.let {
        val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(it))
        birthDay.value = formattedDate
    }
}






























