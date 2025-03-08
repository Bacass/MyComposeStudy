package com.example.dialogex.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.dialogex.LoadingState

@Composable
fun GlobalLoadingDialogScreen() {
    val isLoading = LoadingState.isLoading.collectAsState().value

    if (isLoading) {
        Dialog(
            onDismissRequest = { LoadingState.hide() },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ProcessGlobalLoadingDialogButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonColors(
            containerColor = Color.Blue,
            contentColor = Color.White,
            disabledContainerColor = Color.Blue,
            disabledContentColor = Color.White
        ),
        shape = RectangleShape,
        onClick = {
            LoadingState.show()
        }
    ) {
        Text(
            "LoadingDialog",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White
        )
    }

    GlobalLoadingDialogScreen()
}








