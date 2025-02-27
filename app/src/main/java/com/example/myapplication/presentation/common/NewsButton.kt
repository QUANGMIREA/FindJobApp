package com.example.myapplication.presentation.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun NewsTextButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit

){
    TextButton(onClick = onClick,modifier= modifier.height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF469E67)), shape = RoundedCornerShape(8.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
            color = Color.White,

            )
    }
}
@Composable
fun NewsTextButton2(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit

){
    TextButton(onClick = onClick,modifier= modifier.height(48.dp).border(width = 1.dp, color = Color(0xFF6FCF97),shape= RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)), shape = RoundedCornerShape(8.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold,fontSize = 16.sp),
            color = Color(0xFF6FCF97),

            )
    }
}
@Composable
fun NewsTextButton3(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit

){
    Button(onClick = onClick,modifier= modifier.height(48.dp).border(width = 1.dp, color = Color(0xFF6FCF97),shape= RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFFFF)), shape = RoundedCornerShape(8.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold,fontSize = 16.sp),
            color = Color(0xFFEF4F4F),

            )
    }
}



