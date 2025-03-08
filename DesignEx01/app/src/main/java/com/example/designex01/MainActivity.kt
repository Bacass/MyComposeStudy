package com.example.designex01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designex01.ui.theme.DesignEx01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DesignEx01Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { padding ->
        Box {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.White)
            ) {
                DrawTopArea()
                DrawCurrentMyMoney()
                DrawFunctionArea()
                DrawTransactions()
            }
            Box(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)) {
                DrawFloatingButtons()
            }
        }
    }
}

@Composable
fun MakeProfile(image: Painter, name: String, msg: String) {
    Row(
        modifier = Modifier
            .height(70.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                name,
                color = Color.Black,
                modifier = Modifier.padding(start = 14.dp, top = 5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                msg,
                color = Color.Black,
                modifier = Modifier.padding(start = 14.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun DrawTopArea() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        MakeProfile(
            image = painterResource(R.drawable.profile02),
            "Hey, Dean",
            "Welcome Back"
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.baseline_qr_code_scanner_24),
            modifier = Modifier.size(25.dp),
            contentDescription = "profile image"
        )
    }
}

@Composable
fun DrawCurrentMyMoney() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "$",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            "150,301.3",
            fontSize = 45.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun DrawFunctionArea() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.weight(1f))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF62C267)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_downward_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.height(4.dp))
            Text("Deposit", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
        }
        Spacer(Modifier.width(30.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF62C267)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_arrow_upward_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                "Withdraw",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
        Spacer(Modifier.width(30.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF62C267)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_compare_arrows_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                "Transfer",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun DrawTransactionArea(item: TransferData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.padding(10.dp))

        MakeProfile(
            image = painterResource(item.image),
            name = item.name,
            msg = item.msg
        )

        Spacer(Modifier.weight(1f))

        Column(
            modifier = Modifier.padding(end = 20.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                item.money,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Text(
                item.time,
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun DrawTransactions() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 28.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)) // 모서리 반경
                .background(Color(0xFFEEEEEE)),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .size(width = 40.dp, height = 2.dp)
                    .background(Color(0xFF62C267))
            )

            Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .height(80.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Transactions",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(Modifier.weight(1f))

                    OutlinedCard(
                        modifier = Modifier.size(90.dp, 34.dp),
                        shape = RoundedCornerShape(17.dp),
                        border = BorderStroke(1.dp, Color.DarkGray),
                        colors = CardDefaults.outlinedCardColors(
                            containerColor = Color.Transparent,
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                "October",
                                modifier = Modifier.padding(horizontal = 5.dp),
                                color = Color.Black,
                                fontSize = 14.sp
                            )

                            Image(
                                painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                                modifier = Modifier.size(20.dp),
                                contentDescription = "arrow"
                            )
                        }
                    }
                }

                val transferData: ArrayList<TransferData> = arrayListOf()
                transferData.add(
                    TransferData(
                        image = R.drawable.profile02,
                        "Adam West",
                        "Received",
                        "+$200",
                        "3:25PM"
                    )
                )
                transferData.add(
                    TransferData(
                        image = R.drawable.profile03,
                        "Spotify",
                        "Subscription",
                        "-$4.99",
                        "Dec.19th"
                    )
                )
                transferData.add(
                    TransferData(
                        image = R.drawable.profile04,
                        "Jenny Wilson",
                        "Transfer",
                        "+$50",
                        "Dec.17th"
                    )
                )
                transferData.add(
                    TransferData(
                        image = R.drawable.profile01,
                        "Lawson",
                        "Shopping",
                        "-$187",
                        "Dec.15th"
                    )
                )
                transferData.add(
                    TransferData(
                        image = R.drawable.profile02,
                        "Adam West",
                        "Received",
                        "+$100",
                        "Dec.5th"
                    )
                )

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(transferData) { item ->
                        DrawTransactionArea(item)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawFloatingButtons() {
    Row(
        modifier = Modifier
            .size(230.dp, 80.dp)
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier.padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF62C267)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_home_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.size(5.dp))
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF434343)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_shopping_bag_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
            Spacer(Modifier.size(5.dp))
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF434343)),
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_settings_24),
                    modifier = Modifier.size(36.dp),
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignEx01Theme {
        MainScreen()
    }
}