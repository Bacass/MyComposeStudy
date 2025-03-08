package com.example.dialogex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dialogex.screen.ProcessCustomBottomSheetDialogButton
import com.example.dialogex.screen.ProcessCustomDialogButton
import com.example.dialogex.screen.ProcessGlobalLoadingDialogButton
import com.example.dialogex.ui.theme.DialogExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()

        enableEdgeToEdge()
        setContent {
            DialogExTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.onBackground)
                ) { innerPadding ->
                    MainScreen(
                        viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProcessCustomDialogButton(viewModel)

        Spacer(Modifier.height(10.dp))

        ProcessCustomBottomSheetDialogButton(viewModel)

        Spacer(Modifier.height(10.dp))

        ProcessGlobalLoadingDialogButton()
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = MainViewModel()
    DialogExTheme {
        MainScreen(viewModel)
    }
}