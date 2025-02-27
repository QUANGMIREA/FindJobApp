package com.example.myapplication.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog

import com.example.myapplication.R

@Composable
fun OverProfileScreen() {
    val backgroundColor = Color(0xFFF6F5FA)
    val scrollState = rememberScrollState()
    var showUploadOptions by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header với background màu xanh
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFF0033CC))
            )

            // Card chứa thông tin profile
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-20).dp),  // Adjusted offset to prevent avatar from being hidden
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar
                    Image(
                        painter = painterResource(id = R.drawable.profile_avatar),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape)

                    )

                    Spacer(modifier = Modifier.height(16.dp)) // Adjusted spacing for avatar visibility

                    // Tên và thông tin
                    Text(
                        text = "Le Hong Quang",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "ID: 1012324566512",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "Fresher UI/UX Designer",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Facebook link
                    Text(
                        text = "www.facebook.com/thuyxinhhdeppp",
                        fontSize = 14.sp,
                        color = Color(0xFF0066CC)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = { },
                            modifier = Modifier.padding(horizontal = 4.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
                        ) {
                            Text("Chỉnh sửa", color = Color.Black)
                        }

                        Button(
                            onClick = { },
                            modifier = Modifier.padding(horizontal = 4.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE0E0E0))
                        ) {
                            Text("Chia sẻ", color = Color.Black)
                        }
                    }
                }
            }

            //Spacer(modifier = Modifier.height(8.dp))

            // Card thông tin chung
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Thông tin chung",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    InfoRow("Ngày sinh", "21/01/2002")
                    InfoRow("Địa chỉ email", "quanghx13@gmail.com")
                    InfoRow("Số điện thoại", "0345859102")
                    InfoRow("Địa chỉ", "11-я парковая д36, Москва")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Card Skills
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Skill in job",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    SkillRow("Kĩ năng thực tế", "UI Design, UX Design")

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Text("Thêm", color = Color(0xFF0066CC))
                        Image(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    SkillRow("Kĩ năng mềm", "Canva, Word, English IELTS 7.0")

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Text("Thêm", color = Color(0xFF0066CC))
                        Image(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Upload CV
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .drawWithCache {
                            val strokeWidth = 2.dp.toPx()
                            val dashPathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(10f, 10f), // Độ dài của nét và khoảng trống
                                0f
                            )
                            onDrawBehind {
                                drawRoundRect(
                                    color = Color(0xFF0066CC),
                                    style = Stroke(
                                        width = strokeWidth,
                                        pathEffect = dashPathEffect
                                    ),
                                    cornerRadius = CornerRadius(8.dp.toPx())
                                )
                            }
                        }
                        .clickable { showUploadOptions = true }
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(Color(0xFF0066CC), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Upload your CV, product here PDF, IMG",
                            color = Color(0xFF0066CC)
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = 4.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)

                ) {
                    Text(
                        text = "Setting Profile",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color(0xFF0066CC),
                        modifier = Modifier.fillMaxWidth()

                    )

                }
            }
        }
// Dialog hiển thị khi click vào Upload CV
        if (showUploadOptions) {
            Dialog(onDismissRequest = { showUploadOptions = false }) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 8.dp,
                    backgroundColor = Color.White
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Choose upload option",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Option 1: PDF
                        Button(
                            onClick = {
                                // Xử lý upload PDF
                                showUploadOptions = false
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0066CC))
                        ) {
                            Text("PDF", color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Option 2: IMG
                        Button(
                            onClick = {
                                // Xử lý upload IMG
                                showUploadOptions = false
                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0066CC))
                        ) {
                            Text("IMG", color = Color.White)
                        }
                    }
                }
            }
        }

    }
}




@Preview(showBackground = true)
@Composable
fun PreviewOverProfilScreen() {
    OverProfileScreen()
}

