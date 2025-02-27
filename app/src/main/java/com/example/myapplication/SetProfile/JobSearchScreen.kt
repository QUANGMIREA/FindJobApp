import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderColors
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.presentation.common.NewsTextButton
import com.example.myapplication.presentation.common.NewsTextButton2

@Composable
fun JobSearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        // Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp) // Chiều cao vùng xám
                .background(Color(0xFFF6F5FA)) // Màu nền xám
        ) {
            Text(
                text = "Поиск \n" +
                        "работы прямо ",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF469E67),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 16.dp) // Canh lề trái và phải
                    .background(Color(0xFFF6F5FA)) // Nền xám
                    .padding(8.dp) // Padding cho text
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
// Ngành nghề
            Text(text = "Выберите желаемую профессию :", fontWeight = FontWeight.Bold)

            // Sử dụng LazyVerticalGrid để tạo lưới các tags ngành nghề
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // 3 cột trong lưới
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                itemsIndexed(listOf("Java coder", "Tester", "Java coder", "AI", "NE", "BA", "BackendDev","C++ dev")) { index, item ->
                    JobTag(text = item)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Khoảng cách
            Text(text = "Выберите желаемое расстояние :", fontWeight = FontWeight.Bold)
            SliderWithLabel(value = 4f)

            Spacer(modifier = Modifier.height(16.dp))

            // Mức lương
            Text(text = "Выберите желаемую зарплату :", fontWeight = FontWeight.Bold)
            SliderWithLabel(value = 10f, isSalary = true)

            Spacer(modifier = Modifier.height(52.dp))

            // Buttons
            Column(modifier = Modifier.fillMaxWidth()) {
                NewsTextButton(
                    modifier = Modifier.fillMaxWidth(1f),
                    text = "Подтвердить",
                    onClick = {
                    },

                    )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                NewsTextButton2(
                    modifier = Modifier.fillMaxWidth(1f),
                    text = "Отменить",
                    onClick = {
                    },

                    )

            }
        }

    }
}

@Composable
fun JobTag(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(4.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(8.dp),
        style = MaterialTheme.typography.body2,
        color = Color.Black
    )
}

@Composable
fun SliderWithLabel(value: Float, isSalary: Boolean = false) {
    val label = if (isSalary) "$value Rub" else "$value km"
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = value,
            onValueChange = { /* Cập nhật giá trị khi kéo slider */ },
            valueRange = if (isSalary) 0f..30f else 0f..10f,
            modifier = Modifier.fillMaxWidth(),
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF6FCF97), // Thumb color
                activeTrackColor = Color(0xFF6FCF97), // Active track color
                inactiveTrackColor = Color(0xFFBDBDBD) // Inactive track color (optional)
            )
        )
        Text(text = label, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJobSearchScreen() {
    JobSearchScreen()
}
