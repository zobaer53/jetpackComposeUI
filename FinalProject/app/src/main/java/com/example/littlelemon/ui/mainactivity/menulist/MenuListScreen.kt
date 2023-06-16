package com.example.littlelemon.ui.mainactivity.menulist


import android.annotation.SuppressLint
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.data.dishrepository.DishRepository
import com.example.littlelemon.ui.mainactivity.bottomnav.MyBottomNavigation
import com.example.littlelemon.ui.mainactivity.home.MenuDish
import com.example.littlelemon.ui.theme.LittleLemonColor
import kotlinx.coroutines.CoroutineScope

val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MenuListScreen(
    navController: NavHostController,
    context: Context,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    selectedIndex: MutableState<Int>
) {
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {  if (scaffoldState.drawerState.isClosed) {
                MyBottomNavigation(navController = navController, selectedIndex = selectedIndex)
            }},
            topBar = {
                com.example.littlelemon.ui.topbar.TopAppBar(
                    null,
                    coroutineScope,
                    navController
                )
            }
        ){
            Column {
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
