package com.example.littlelemon.ui.mainactivity.cartitem

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.R
import com.example.littlelemon.ui.mainactivity.dishdetails.Counter
import com.example.littlelemon.ui.theme.LittleLemonColor

data class FoodItem(val name: String, val imageResId: Int, val price: String)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun CartScreen(navController: NavHostController) {
    val cartItems = mutableStateListOf(
        FoodItem("Pizza", R.drawable.bruschetta, "$10"),
        FoodItem("Burger", R.drawable.pasta, "$8"),
        FoodItem("Pasta", R.drawable.greeksalad, "$12")
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Cart", color = LittleLemonColor.yellow)},
                navigationIcon = {
                    IconButton(onClick = {

                        navController.popBackStack()

                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = LittleLemonColor.green
            )
        }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            if (cartItems.isEmpty()) {
                Text(text = "Your cart is empty", style = MaterialTheme.typography.h5)
            } else {
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(cartItems) { item ->
                        CartItem(item)
                    }
                }
                Button(
                    onClick = { /* Handle checkout */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = LittleLemonColor.yellow
                    )
                ) {
                    Text(text = "Checkout", color = LittleLemonColor.black)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItem(foodItem: FoodItem) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImage(model = foodItem.imageResId, contentDescription =null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = foodItem.name, style = MaterialTheme.typography.h6)
                Text(text = "Price: ${foodItem.price}", style = MaterialTheme.typography.body1)
            }
            Counter()
        }
    }
}
