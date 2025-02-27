package com.example.myapplication.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun JobCategoryCard(title: String, iconResId: Int, count: Int) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), // Ensures the card takes up the full width available
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp), // Rounded corners for a soft, rectangular look
        backgroundColor = Color.White
    ) {
        Box(
            modifier = Modifier.padding(12.dp)
        ) {
            // Icon at the top-left corner
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray.copy(alpha = 0.2f), shape = CircleShape)
                    .padding(8.dp)
                    .align(Alignment.TopStart),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            }

            // Title text below the icon
            Text(
                text = title,
                style = TextStyle(fontSize = 16.sp, color = Color.Black),
                modifier = Modifier
                    .padding(top = 56.dp) // Adjust padding based on icon size
                    .align(Alignment.TopStart)
            )

            // Count in the bottom-right corner
            Text(
                text = "$count",
                style = TextStyle(fontSize = 24.sp, color = Color.Blue, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
        }
    }
}

@Preview()
@Composable
fun PreviewTag() {
    JobCategoryCard(
        title = "Việc làm đang ứng tuyển",
        iconResId = R.drawable.filter, // You can use any icon you like here
        count = 3
    )
}
