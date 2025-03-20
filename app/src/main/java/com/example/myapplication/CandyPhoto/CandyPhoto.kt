package com.example.myapplication.CandyPhoto

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun CandyCollectionScreen(navController: NavController) {
    val candyStates = remember { mutableStateListOf(false, false, false, false, false) }
    var showDialog by remember { mutableStateOf(false) }
    var selectedCandyIndex by remember { mutableStateOf(-1) }
    var showSuccessMessage by remember { mutableStateOf(false) }
    val validCode = "123"

    LaunchedEffect(candyStates) {
        if (candyStates.all { it }) {
            Log.d("Success", "All candies collected!")
            showSuccessMessage = true
            Log.d("Success", "showSuccessMessage set to true")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE6F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "PHOTO CANDY", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFA1C9), modifier = Modifier.padding(top = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "THẺ TÍCH ĐIỂM", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFA1C9), modifier = Modifier.padding(top = 8.dp))
            Text(text = "Tích đủ 5 viên kẹo để nhận 1 lượt chụp miễn phí nhé", fontSize = 16.sp, color = Color.Black, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp))
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                candyStates.forEachIndexed { index, isCollected ->
                    CandyItem(isCollected = isCollected, onClick = { selectedCandyIndex = index; showDialog = true })
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = "THANK YOU SO MUCH!", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFFA1C9), modifier = Modifier.padding(bottom = 16.dp))
        }

        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Card(modifier = Modifier.fillMaxWidth().padding(16.dp), elevation = CardDefaults.cardElevation(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        var codeInput by remember { mutableStateOf("") }
                        Text(text = "Nhập mã code", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(value = codeInput, onValueChange = { codeInput = it }, label = { Text("Mã code") }, modifier = Modifier.fillMaxWidth())
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                            Button(onClick = { showDialog = false }) { Text("Hủy") }
                            Button(onClick = {
                                if (codeInput == validCode) {
                                    candyStates[selectedCandyIndex] = true
                                    Log.d("CandyStates", "Updated candyStates: $candyStates")
                                    if (candyStates.all { it }) {
                                        Log.d("Success", "All candies collected!")
                                        showSuccessMessage = true
                                        Log.d("Success", "showSuccessMessage set to true")
                                    }
                                }
                                showDialog = false
                                codeInput = ""
                            }) { Text("Xác nhận") }
                        }
                    }
                }
            }
        }

        if (showSuccessMessage) {
            Log.d("Success", "Showing AlertDialog")
            AlertDialog(
                onDismissRequest = { showSuccessMessage = false },
                title = { Text("Chúc mừng!") },
                text = { Text("Bạn đã nhận được 1 lượt chụp miễn phí!") },
                confirmButton = {
                    Button(onClick = {
                        showSuccessMessage = false
                        candyStates.forEachIndexed { index, _ -> candyStates[index] = false }
                        Log.d("Success", "OK clicked")
                    }) { Text("OK") }
                }
            )
        }
    }
}

@Composable
fun CandyItem(isCollected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(if (isCollected) Color.Gray else Color(0xFFFFA1C9))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        if (isCollected) {
            Text(
                text = "✔",
                fontSize = 24.sp,
                color = Color.White
            )
        }
    }
}

@Preview()
@Composable
fun PreviewCandyPhoto() {
    val navController = rememberNavController()
    CandyCollectionScreen(navController)
}
