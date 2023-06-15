package com.example.littlelemon.ui.mainactivity.menulist


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.dishrepository.DishRepository
import com.example.littlelemon.ui.mainactivity.home.MenuDish
import com.example.littlelemon.ui.theme.LittleLemonColor

val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

@Composable
fun MenuListScreen(navController: NavHostController, context: Context) {
    val coroutineScope = rememberCoroutineScope()

    Column {
        com.example.littlelemon.ui.topbar.TopAppBar(
            null,
            coroutineScope,
            navController
        )
        UpperPanelMenuPage()

        Column {
            LazyRow {
                items(Categories) { category ->
                    MenuCategory(category)
                }
            }
            Divider(
                modifier = Modifier.padding(8.dp),
                color = Color.Gray,
                thickness = 1.dp
            )
            LazyColumn {
                items(DishRepository.dishes) { Dish ->
                    MenuDish(navController,Dish)
                }
            }
        }
    }
}
@Composable
private fun UpperPanelMenuPage() {
    Column(
        modifier = Modifier
            .background(Color(0xFF495E57))
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 16.dp)
    ) {

        Text(
            text = "ORDER FOR TAKEAWAY",
            fontSize = 24.sp,
            fontWeight = Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        , color = LittleLemonColor.cloud
        )
    }
}
@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = category
        )
    }
}
