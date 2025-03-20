package com.example.myapplication.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.presentation.common.ContainerBorder
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import com.example.myapplication.API.RetrofitClient
import com.example.myapplication.DataClass.Job
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.shadow
import androidx.core.text.HtmlCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        modifier = Modifier.height(56.dp)
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        BottomNavigationItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.store),
                        contentDescription = "Home Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            label = {
                Text(
                    text = "Home",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            },
            selected = currentRoute == "HomeScreen",
            onClick = {
                navController.navigate("HomeScreen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shopping_cart),
                        contentDescription = "Cart Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            label = {
                Text(
                    text = "Cart",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            },
            selected = currentRoute == "CartScreen",
            onClick = {
                navController.navigate("CartScreen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.grocery_store),
                        contentDescription = "Grocery Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            label = {
                Text(
                    text = "Store",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            },
            selected = currentRoute == "StoreScreen",
            onClick = {
                navController.navigate("StoreScreen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.diet),
                        contentDescription = "Diet Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            label = {
                Text(
                    text = "Diet",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            },
            selected = currentRoute == "BagScreen",
            onClick = {
                navController.navigate("BagScreen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )

        BottomNavigationItem(
            icon = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.school_bag),
                        contentDescription = "BackPack Icon",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            },
            label = {
                Text(
                    text = "Reserve",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            },
            selected = false,
            onClick = {
                // Có thể thêm navigation sau này
            },
            selectedContentColor = Color(0xFF469E67),
            unselectedContentColor = Color.Gray
        )
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    var searchResults by remember { mutableStateOf<List<Job>>(emptyList()) }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF6F5FA))
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                HeaderWithNotification()
                Spacer(Modifier.height(26.dp))
                SearchBar(
                    onSearch = { query ->
                        searchQuery = query
                        scope.launch(Dispatchers.IO) {
                            isLoading = true
                            errorMessage = null
                            try {
                                println("Searching for: $query")
                                val response = RetrofitClient.instance
                                    .searchJobs(query, visaSponsorship = true)
                                    .execute()
                                println("Response Code: ${response.code()}")
                                println("Response Message: ${response.message()}")

                                if (response.isSuccessful) {
                                    val body = response.body() // Access the parsed response body directly
                                    if (body != null) {

                                        searchResults = body.data.filter { job ->
                                            job.company_name.contains(searchQuery, ignoreCase = true)
                                        }                                    } else {
                                        errorMessage = "Response body is null"
                                    }
                                } else {
                                    errorMessage = "HTTP Error: ${response.code()} - ${response.message()}"
                                }
                            } catch (e: HttpException) {
                                errorMessage = "HTTP Exception: ${e.code()} - ${e.message()}"
                                e.printStackTrace()
                                println("HTTP Exception Stack Trace: ${e.stackTraceToString()}")
                            } catch (e: IOException) {
                                errorMessage = "Network Error: ${e.message}"
                                e.printStackTrace()
                                println("Network Error Stack Trace: ${e.stackTraceToString()}")
                            } catch (e: Exception) {
                                errorMessage = "Unexpected Error: ${e.message ?: "Unknown error"} - Stack Trace: ${e.stackTraceToString()}"
                                e.printStackTrace()
                                println("Unexpected Error Stack Trace: ${e.stackTraceToString()}")
                            } finally {
                                isLoading = false
                            }
                        }

                    }
                )
                Spacer(Modifier.height(10.dp))

                if (isLoading) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                } else if (errorMessage != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = errorMessage!!,
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                scope.launch(Dispatchers.IO) {
                                    isLoading = true
                                    errorMessage = null
                                    try {
                                        val response =
                                            RetrofitClient.instance.searchJobs(searchQuery).execute()
                                        if (response.isSuccessful) {
                                            val body =
                                                response.body()
                                            if (body != null) {
                                                searchResults =
                                                    body.data.filter { job ->
                                                        job.company_name.contains(searchQuery, ignoreCase =
                                                        true)
                                                    }
                                            } else {
                                                errorMessage =
                                                    "Response body is null"
                                            }
                                        } else {
                                            errorMessage =
                                                "HTTP Error: ${response.code()} - ${response.message()}"
                                        }
                                    } catch (e: HttpException) {
                                        errorMessage =
                                            "HTTP Exception: ${e.code()} - ${e.message()}"
                                    } catch (e: IOException) {
                                        errorMessage =
                                            "Network Error: ${e.message}"
                                    } catch (e: Exception) {
                                        errorMessage =
                                            "Unexpected Error: ${e.message ?: "Unknown error"}"
                                    } finally {
                                        isLoading =
                                            false
                                    }
                                }
                            },
                            colors =
                            ButtonDefaults.buttonColors(backgroundColor =
                            Color(0xFF469E67))
                        ) {
                            Text(
                            text =  "Обновить",
                            color = Color.White
                        )
                        }
                    }


                } else if (searchResults.isNotEmpty()) {
                    LazyColumn {
                        items(searchResults) { job ->
                            JobItem(job = job)
                        }
                    }
                } else if (searchQuery.isNotEmpty() && searchResults.isEmpty()) {
                    Text(
                        text = "No results for '$searchQuery'",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                } else {
                    JobCategoryGrid()
                    Spacer(Modifier.height(10.dp))
                    Column(modifier = Modifier.fillMaxWidth()) {
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
                                text = "Посмотреть всё",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF469E67)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun JobItem(job: Job) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Tiêu đề công việc
            Text(
                text = job.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF469E67),
                modifier = Modifier.padding(bottom = 8.dp)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.company_icon),
                    contentDescription = "Company Logo",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = job.company_name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color(0xFF616161)
                )
            }

            Text(
                text = "Location: ${job.location}",
                fontSize = 16.sp,
                color = Color(0xFF9E9E9E),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            val formattedDescription = HtmlCompat.fromHtml(
                job.description,
                HtmlCompat.FROM_HTML_MODE_COMPACT
            ).toString()

            Text(
                text = formattedDescription,
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Button(
                onClick = { /* Thực hiện hành động khi nhấn */ },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF469E67))
            ) {
                Text(
                    text = "Apply Now",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
fun HeaderWithNotification() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Исследуйте популярные продукты",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF469E67),
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(40.dp)
        ) {
            IconButton(onClick = {

            }){
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = "Notification",
                    modifier = Modifier.size(38.dp),
                    tint = Color.Unspecified
                )
            }


            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(16.dp)
                    .background(Color.Red, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1",
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}





@Composable
fun SearchBar(
    onSearch: (String) -> Unit = {}
) {
    var text by rememberSaveable { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    val scope = rememberCoroutineScope()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
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
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )

                Spacer(modifier = Modifier.width(8.dp))

                OutlinedTextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                        if (newText.isNotEmpty()) {
                            scope.launch {
                                onSearch(newText)
                            }
                        }
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(58.dp)
                        .focusRequester(focusRequester),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                    ),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    placeholder = { Text("Поиск компания") },
                    trailingIcon = {
                        if (text.isNotEmpty()) {
                            Icon(
                                painter = painterResource(id = R.drawable.close_1),
                                contentDescription = "Clear",
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        text = ""
                                        focusManager.clearFocus()
                                    },
                                tint = Color.Unspecified
                            )
                        }
                    }
                )
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(42.dp)
                .background(Color(0x00000000)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                modifier = Modifier.size(42.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun JobCategoryGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(4) { index ->
            val title = when (index) {
                0 -> "Работа, на которую подано заявление"
                1 -> "Успешная подача заявки"
                2 -> "Компания отслеживает"
                3 -> "Работа, которая вас интересует"
                else -> ""
            }

            val iconResId = when (index) {
                0 -> R.drawable.pic1
                1 -> R.drawable.pic2
                2 -> R.drawable.pic3
                3 -> R.drawable.pic4
                else -> R.drawable.filter
            }

            JobCategoryCard(
                title = title,
                iconResId = iconResId,
                count = 2
            )
        }
    }
}

@Composable
fun DailyMenuSection() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ) {
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food,
            colorTransform1 = Color(0xFFFA8173),
            colorTransform2 = Color(0xFFFEA885)
        )
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food,
            colorTransform1 = Color(0xFFFBBF64),
            colorTransform2 = Color(0xFFF9D37D)
        )
        ContainerBorder(
            textTitle = "Bữa sáng",
            textTime = "6:00",
            text = "Bữa ăn chiếm 15% lượng Kcal / ngày",
            image = R.drawable.pet_food,
            colorTransform1 = Color(0xFFB79CFD),
            colorTransform2 = Color(0xFF9889FC)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    val navController = rememberNavController()
    HomeScreen(navController)
}