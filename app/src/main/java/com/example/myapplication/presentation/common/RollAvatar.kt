package com.example.myapplication.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun ProfileCard(
    image: Painter,
    name: String,
    role1: String,
    role2: String
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        // Image Profile
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Text and Roles
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Row {
                // Role 1 Button
                Button(
                    onClick = {},
                    modifier = Modifier.padding(end = 8.dp),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White, // Nền trắng
                        contentColor = Color.Black // Chữ đen
                    )
                ) {
                    Text(text = role1)
                }


                // Role 2 Button
                Button(
                    onClick = {},
                    modifier = Modifier.padding(end = 8.dp),
                    shape = RoundedCornerShape(50),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White, // Nền trắng
                        contentColor = Color.Black // Chữ đen
                    )
                ) {
                    Text(text = role2)
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileCard() {
    ProfileCard(
        image = painterResource(id = R.drawable.profile_picture), // Replace with actual image resource
        name = "Hong Quang",
        role1 = "Java Coder",
        role2 = "Designer"
    )
}
