package com.lee.mycomposeex

import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.lee.mycomposeex.ui.theme.MyComposeExTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
//            MyComposeExTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android", modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }

            val viewModel = viewModel<MainViewModel>()

            var granted by remember { mutableStateOf(false) }

            val launcher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
                    granted = isGranted
                }

            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.TIRAMISU) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    granted = true
                }
            } else {
                if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_MEDIA_IMAGES,
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    granted = true
                }
            }

            if (granted) {
                viewModel.fetchPhotos()
                HomeScreen(photoUris = viewModel.photoUris.value)
            } else {
                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.TIRAMISU) {
                    PermissionRequestScreen {
                        launcher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    }
                } else {
                    PermissionRequestScreen {
                        launcher.launch(android.Manifest.permission.READ_MEDIA_IMAGES)
                    }
                }
            }

        }
    }
}

@Composable
fun PermissionRequestScreen(onClick: () -> Unit) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("권한이 허용되지 않았습니다.")
//        Button(onClick = onClick) {
//            Text(text = "권한 요청")
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("권한이 허용되지 않았습니다.")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onClick) {
            Text("권한 요청", fontSize = 16.sp)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(photoUris: List<Uri>) {
    val pagerState = rememberPagerState(pageCount = { photoUris.size })

    Column(Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .fillMaxSize()
        ) { pageIndex ->
            Card(
                modifier = Modifier
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction
                                ).absoluteValue

                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }

                        alpha = lerp(
                            start = 0.5f, stop = 1f, fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                AsyncImage(
                    model = photoUris[pageIndex],
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(photoUris.size) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray

                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(20.dp)
                )
            }
        }
    }
}

private fun lerp(start: Float, stop: Float, fraction: Float): Float =
    (1 - fraction) * start + fraction * stop


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val (text, setText) = remember {
//        mutableStateOf("")
//    }
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(color = MaterialTheme.colorScheme.primary)
//            .padding(25.dp)
//    ) {
//        Column {
//            Text(text = "Hello World")
//            Spacer(modifier = modifier.size(16.dp))
//
//            Row(modifier = Modifier.fillMaxWidth()) {
//                Text(
//                    text = name, color = Color.Red,
//                    modifier = Modifier
//                        .width(80.dp)
//                        .background(Color.Gray),
//                    textAlign = TextAlign.Left
//                )
//                Spacer(modifier = modifier.size(16.dp))
//                Text(
//                    text = name, color = Color.Blue,
//                    modifier = Modifier
//                        .width(80.dp)
//                        .background(Color.Gray),
//                    textAlign = TextAlign.Center
//                )
//                Spacer(modifier = modifier.size(16.dp))
//                Text(
//                    text = name,
//                    color = Color.Green,
//                    modifier = Modifier
//                        .width(80.dp)
//                        .background(Color.Gray),
//                    textAlign = TextAlign.End
//                )
//            }
//
//            Spacer(modifier = modifier.size(16.dp))
//
//            Box(
//                modifier = modifier.background(Color.White)
//            ) {
//                OutlinedTextField(value = text,
//                    onValueChange = setText,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 10.dp)
//                        .height(55.dp),
//                    placeholder = { Text(text = "placeholder", color = Color.Black) })
//            }
//
//            Spacer(modifier = modifier.size(16.dp))
//
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(shape = RoundedCornerShape(16.dp))
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.Blue)
//                        .padding(16.dp)
//                ) {
//                    Column(modifier = Modifier.weight(1f)) {
//                        Text(text = "Hello", color = Color.White)
//                        Text(text = "World!", color = Color.White)
//                    }
//
//                    Button(onClick = { }) {
//                        Text(text = "OK")
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyComposeExTheme {
//        Greeting("Android")
//    }
//}