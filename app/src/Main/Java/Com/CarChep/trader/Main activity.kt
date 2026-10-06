package com.carchep.trader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CarChepDashboard()
            }
        }
    }
}

@Composable
fun CarChepDashboard() {
    var isLiveMode by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "CarChep Trader", fontSize = 28.sp)
        Text(text = "Protect Capital. Make Profits.", fontSize = 14.sp, color = Color.Gray)
        
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                onClick = { isLiveMode = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isLiveMode) Color(0xFF4CAF50) else Color.Gray
                )
            ) { Text("LIVE") }
            
            Spacer(modifier = Modifier.width(10.dp))
            
            Button(
                onClick = { isLiveMode = false },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!isLiveMode) Color(0xFF2196F3) else Color.Gray
                )
            ) { Text("JOURNAL (TARGET)") }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = if (isLiveMode) "Mode: Free Trading" else "Mode: Daily Target")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Symbol: GainX 400")
                Text(text = "Balance: $10.00")
                if (!isLiveMode) {
                    Text(text = "Today's Target: $2.50", color = Color(0xFF2196F3))
                }
                
                Spacer(modifier = Modifier.height(20.dp))
                
                Row {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        modifier = Modifier.weight(1f)
                    ) { Text("BUY") }
                    
                    Spacer(modifier = Modifier.width(10.dp))
                    
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                        modifier = Modifier.weight(1f)
                    ) { Text("SELL") }
                }
            }
        }
    }
}
