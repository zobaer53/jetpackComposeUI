package com.example.littlelemon.ui.mainactivity.location

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.ui.theme.LittleLemonTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    LittleLemonTheme() {
        Scaffold(
            topBar = {
                com.example.littlelemon.ui.topbar.TopAppBar()
            }
        ) {
            Column(


            ) {
                Column(modifier = Modifier.background(LittleLemonColor.green)
                    .padding(horizontal = 16.dp, vertical = 8.dp)) {
                    ProfileHeader()
                    Spacer(modifier = Modifier.height(16.dp))
                    ProfileInfoSection()
                    Spacer(modifier = Modifier.height(24.dp))
                }

                FavoriteRecipesSection()
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.person_icon),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(shape = MaterialTheme.shapes.large)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "John Doe", fontWeight = FontWeight.Bold,color = LittleLemonColor.yellow, fontSize = 39.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "johndoe@example.com", color = LittleLemonColor.cloud)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Los Angeles, CA", color = LittleLemonColor.cloud)
        }
    }
}

@Composable
fun ProfileInfoSection() {
    Column {
        Text(text = "User Information", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        UserInfoRow(Icons.Filled.DateRange, "Date of Birth", "Jan 1, 1990")
        Spacer(modifier = Modifier.height(8.dp))
        UserInfoRow(Icons.Filled.Phone, "Phone Number", "+1 123-456-7890")
        Spacer(modifier = Modifier.height(8.dp))
        UserInfoRow(Icons.Filled.Lock, "Password", "********")
    }
}

@Composable
fun UserInfoRow(icon: ImageVector, label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = "User Information Icon",
            tint = LittleLemonColor.cloud
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = label, fontWeight = FontWeight.Bold,color = LittleLemonColor.cloud)
            Text(text = value,color = LittleLemonColor.cloud)
        }
    }
}

@Composable
fun FavoriteRecipesSection() {
    Column( Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(text = "Favorite Recipes", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(recipeList) { recipe ->
                FavoriteRecipeItem(recipe)
            }
        }
    }
}

@Composable
fun FavoriteRecipeItem(recipe: String) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Recipe Icon",
                tint = LittleLemonColor.green
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = recipe)
        }
    }
}

// Sample data for favorite recipes
val recipeList = listOf(
    "Spaghetti Bolognese",
    "Chicken Tikka Masala",
    "Margherita Pizza",
    "Chocolate Chip Cookies",
    "Greek Salad"
)



@Composable
@Preview(showBackground = true)
fun LocationScreenPreview() {
    ProfileScreen()
}