package com.example.myapplication.homescreen

import android.graphics.drawable.Icon
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.ContainerBorder

@Composable
fun BottomNavigationBar(currentScreen: MutableState<Screen>) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        // modifier = Modifier.offset(y = (-35).dp) // Di chuyển BottomNavigationBar lên 4dp

    ) {
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.store), // Thay thế bằng ảnh của bạn
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước nếu cần
                )
            },
            label = {
                Text(
                    "Home",
                    fontSize = 10.sp
                )
            },
            selected = currentScreen.value is Screen.Home,
            onClick = {
                currentScreen.value = Screen.Home
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.shopping_cart), // Thay thế bằng ảnh của bạn
                    contentDescription = "Cart Icon",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước nếu cần
                )
            },
            label = { Text("Cart",
                fontSize = 10.sp) },
            selected = false,
            onClick = {
                currentScreen.value = Screen.Cart
            }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.grocery_store), // Thay thế bằng ảnh của bạn
                    contentDescription = "Grocery Icon",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước nếu cần
                )
            },
            label = { Text("Store", fontSize = 10.sp) },
            selected = currentScreen.value is Screen.Store,
            onClick = { currentScreen.value = Screen.Store },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.diet), // Thay thế bằng ảnh của bạn
                    contentDescription = "Diet Icon",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước nếu cần
                )
            },
            label = { Text("Diet", fontSize = 10.sp) },
            selected = currentScreen.value is Screen.Bag,
            onClick = {
                currentScreen.value = Screen.Bag
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.school_bag), // Thay thế bằng ảnh của bạn
                    contentDescription = "BackPack Icon",
                    modifier = Modifier.size(24.dp) // Điều chỉnh kích thước nếu cần
                )
            },
            label = { Text("Reserve", fontSize = 10.sp) },
            selected = false,
            onClick = {

            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )
    }
}

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize(
            )
            .background(Color(0xFFF6F5FA))
    )
    {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            HeaderWithNotification()
            Spacer(Modifier.height(26.dp))
            SearchBar()
            Spacer(Modifier.height(10.dp))
            JobCategoryGrid()
            Spacer(Modifier.height(10.dp))
            Column( modifier = Modifier
                .fillMaxWidth()) {
                Text(
                    text = "Выделяющаяся компания >",
                    style = TextStyle(fontSize = 24.sp, color = Color(0xFF469E67)),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                DailyMenuSection()
                Spacer(Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = "Подходит вам",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF469E67)
                    )
                    Text(
                        text = "Посмотреть все",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF469E67)
                    )
                }

            }

        }
    }
}
@Composable
fun HeaderWithNotification() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
             // Thêm khoảng cách xung quanh
    ) {
        // Text content
        Text(
            text = "Исследуйте популярные продукты",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF469E67),
            modifier = Modifier.align(Alignment.CenterStart) // Căn chữ ở giữa bên trái
        )

        // Notification Icon
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .align(Alignment.TopEnd) // Đặt icon ở góc trên bên phải
                .size(40.dp) // Kích thước vùng chứa icon
        ) {
            Icon(
                painter = painterResource(id = R.drawable.active), // Thay bằng icon của bạn
                contentDescription = "Notification",
                modifier = Modifier.size(36.dp), // Kích thước icon
                tint = Color.Unspecified // Giữ màu gốc của icon
            )
        }
    }
}

@Composable
fun SearchBar() {
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
                    value = "Поиск работы - компания",
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

        Spacer(modifier = Modifier.width(8.dp))

        // Blue filter icon outside the search bar
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(Color(0xFF2196F3), RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
        }
    }
}




@Composable
fun JobCategoryGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 columns per row
        modifier = Modifier.fillMaxWidth()
    ) {
        items(4) { index ->
            // Sample data for each card
            val title = when (index) {
                0 -> "Работа, на которую подано заявление"
                1 -> "Успешная подача заявки"
                2 -> "Компания отслеживает"
                3 -> "Работа, которая вас интересует"
                else -> ""
            }

            val iconResId = when (index) {
                0 -> R.drawable.pic1 // Replace with the correct icon resource IDs
                1 -> R.drawable.pic2 // Replace with the correct icon resource IDs
                2 -> R.drawable.pic3 // Replace with the correct icon resource IDs
                3 -> R.drawable.pic4 // Replace with the correct icon resource IDs
                else -> R.drawable.filter
            }

            JobCategoryCard(
                title = title,
                iconResId = iconResId,
                count = 2 // Example count for each card
            )
        }
    }
}

@Composable
fun DailyMenuSection() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .padding(0.dp,20.dp,0.dp,0.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState)


    ){
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food, // Replace with the correct image resource
            colorTransform1 = Color(0xFFFA8173), // Replace with your desired colors
            colorTransform2 = Color(0xFFFEA885)
        )
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food, // Replace with the correct image resource
            colorTransform1 = Color(0xFFFBBF64), // Replace with your desired colors
            colorTransform2 = Color(0xFFF9D37D)
        )
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food, // Replace with the correct image resource
            colorTransform1 = Color(0xFFB79CFD), // Replace with your desired colors
            colorTransform2 = Color(0xFF9889FC)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
