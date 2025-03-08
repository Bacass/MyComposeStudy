package com.example.dialogex.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dialogex.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetDialog(
    title: String = "",
    description: String = "",
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit
) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    ModalBottomSheet(
        containerColor = Color.White, // 배경색 설정
        onDismissRequest = { onClickCancel() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = bottomPadding
                )
                .fillMaxWidth()
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = description,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Spacer(Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CountryList()
            }

            Button(
                onClick = {
                    scope.launch {
                        modalBottomSheetState.hide()
                    }.invokeOnCompletion {
                        onClickConfirm()
                    }
                }
            ) {
                Text("Confirm")
            }
        }
    }
}

@Composable
fun CountryList() {
    val context = LocalContext.current
    val list = getCountryList()

    Column {
        list.forEach {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .clickable {
                        Toast.makeText(context, it.first, Toast.LENGTH_SHORT).show()
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = it.first,
                    modifier = Modifier.width(160.dp),
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(Modifier.width(6.dp))
                Text(text = it.second)
            }
        }
    }
}

fun getCountryList(): List<Pair<String, String>> {
    return listOf(
        Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
        Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
        Pair("India", "\uD83C\uDDEE\uD83C\uDDF3"),
        Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
        Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
        Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
        Pair("Brazil", "\uD83C\uDDE7\uD83C\uDDF7"),
        Pair("Australia", "\uD83C\uDDE6\uD83C\uDDFA"),
        Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
        Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
    )
}

@Composable
fun ProcessCustomBottomSheetDialogButton(viewModel: MainViewModel) {
    val customBottomSheetDialogState = viewModel.customBottomSheetDialogState.value

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
            viewModel.showBottomSheetDialog()
            viewModel.showBottomSheetDialog.value = true
        }
    ) {
        Text(
            "CustomBottomSheetDialog",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White
        )
    }

    if (viewModel.showBottomSheetDialog.value) {
        CustomBottomSheetDialog(
            title = customBottomSheetDialogState.title,
            description = customBottomSheetDialogState.description,
            onClickCancel = { customBottomSheetDialogState.onClickCancel() },
            onClickConfirm = { customBottomSheetDialogState.onClickConfirm() }
        )
    }
}




