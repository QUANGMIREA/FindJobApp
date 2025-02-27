package com.example.myapplication.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.MessageCard

@Composable
fun MessageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))

    ) {
        // Search bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Введите ключевое слово", color = Color.Gray) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.White,
                    focusedBorderColor = Color.LightGray,
                    unfocusedBorderColor = Color.LightGray
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                },
                textStyle = TextStyle(fontSize = 14.sp)
            )
        }

        // Pinned messages header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_pin),
                contentDescription = "Pinned",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Закрепленное сообщение",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Red
            )
        }

        // Pinned messages
        MessageCard(
            image = painterResource(id = R.drawable.netflix_logo),
            name = "Виктор",
            message = "Привет!!!",
            time = "8:57"
        )
        MessageCard(
            image = painterResource(id = R.drawable.pic10),
            name = "Иван",
            message = "У меня есть работа, которую я хочу....",
            time = "10:52"
        )

        // Recent messages header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_recent),
                contentDescription = "Recent",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Недавние сообщения",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        // List of recent messages
        LazyColumn(

        ) {
            items(getMessageList()) { messageData ->
                MessageCard(
                    image = painterResource(id = messageData.imageResId),
                    name = messageData.name,
                    message = messageData.message,
                    time = messageData.time
                )
            }
        }
    }
}

// Data class để lưu trữ thông tin tin nhắn
data class MessageData(
    val imageResId: Int,
    val name: String,
    val message: String,
    val time: String
)

// Hàm tạo danh sách tin nhắn mẫu
fun getMessageList(): List<MessageData> {
    return listOf(
        MessageData(
            imageResId = R.drawable.pic11,
            name = "Александр",
            message = "У тебя есть свободное время?",
            time = "6:27"
        ),
        MessageData(
            imageResId = R.drawable.pic12,
            name = "Дмитрий",
            message = "Представь себя",
            time = "3:51"
        ),
        MessageData(
            imageResId = R.drawable.pic13,
            name = "Анастасия",
            message = "Xin chào !!!",
            time = "2:22"
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageScreen() {
    MessageScreen()
}
