package com.example.myapplication.homescreen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.ProfileCard

@Composable
fun SocialScreen(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF6F5FA))

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        )
        {
            HeaderWithNotification()
            Spacer(Modifier.height(26.dp))
            SearchBar2()
            Spacer(modifier = Modifier.height(10.dp))
            ProfileCard(
                image = painterResource(id = R.drawable.profile_picture), // Replace with actual image resource
                name = "Hong Quang",
                role1 = "Java Coder",
                role2 = "Designer")
            Image(
                painter = painterResource(id = R.drawable.pic5), // Replace with your image resource
                contentDescription = "Social Media Marketing",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Adjust height as needed
                contentScale = ContentScale.Crop // Scale the image to fill its bounds
            )
            ProfileCard(
                image = painterResource(id = R.drawable.pic6), // Replace with actual image resource
                name = "Хонг Куанг",
                role1 = "Backend Dev",
                role2 = "UI/UX")
            Image(
                painter = painterResource(id = R.drawable.pic8), // Replace with your image resource
                contentDescription = "Social Media Marketing",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Adjust height as needed
                contentScale = ContentScale.Crop // Scale the image to fill its bounds
            )
                 }
    }
}
@Composable
fun SearchBar2() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Search bar with rounded corners
        Surface(
            color = Color.White,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .weight(1f)
                .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                // Search icon
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Search input field
                OutlinedTextField(
                    value = "Введите ключевое слово",
                    onValueChange = {},
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(color = Color.Gray, fontSize = 15.sp)
                )

            }
        }

        
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewSocialScreen() {
    SocialScreen()
}
