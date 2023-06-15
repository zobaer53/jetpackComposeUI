package com.example.littlelemon.ui.mainactivity.drawer

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonColor
import com.example.littlelemon.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DrawerTopBarScreen() {

            Column() {
                DrawerHeader(img = R.drawable.dp)

                Divider(
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    thickness = 5.dp,
                    color = LittleLemonColor.yellow
                )
                DrawerBody()
            }
        }
        // Content of the screen goes here



@Composable
fun MenuItem(text: String,icon:ImageVector ,isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) LittleLemonColor.green else Color.Transparent
    val textColor = if (isSelected) LittleLemonColor.cloud else Color.Black

    Text(
        text = text,
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .padding(8.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        color = textColor
    )
}

@Preview
@Composable
fun DrawerTopBarScreenPreview() {
    DrawerTopBarScreen()
}
@Composable
fun DrawerHeader(img: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonColor.green)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = img),
            contentDescription = "Header Image",
            modifier = Modifier
                .size(120.dp)
                .clip(shape = RoundedCornerShape(20.dp))
        )
      Column(modifier = Modifier.padding(start = 10.dp)) {
          Text(
              text = "Zobaer Hossain",
              style = MaterialTheme.typography.h6,
              modifier = Modifier.padding(top = 8.dp),
              color = LittleLemonColor.yellow
          )
        /*  Text(text = "hossain.zobaer11858@gmail.com", color = LittleLemonColor.cloud)*/
          Spacer(modifier = Modifier.height(4.dp))
          Text(text = "Dhaka, BD", color = LittleLemonColor.cloud)
      }

    }
}

@Composable
fun DrawerBody() {
    val selectedMenuItem = remember { mutableStateOf(0) }
    Column(    modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(LittleLemonColor.greenSoft)
        .padding(top = 10.dp)
    ) {
        MenuItem(
            text = "Home",
            Icons.Default.Home,
            isSelected = selectedMenuItem.value == 0,
            onClick = { selectedMenuItem.value = 0 }
        )
        MenuItem(
            text = "Menu",
            Icons.Default.Menu,
            isSelected = selectedMenuItem.value == 1,
            onClick = { selectedMenuItem.value = 1 }
        )
        MenuItem(
            text = "Profile",
            Icons.Default.Person,
            isSelected = selectedMenuItem.value == 2,
            onClick = { selectedMenuItem.value = 2 }
        )
        MenuItem(
            text = "Settings",
            Icons.Default.Settings,
            isSelected = selectedMenuItem.value == 3,
            onClick = { selectedMenuItem.value = 3 }
        )

        MenuItem(
            text = "Help",
            Icons.Default.Info,
            isSelected = selectedMenuItem.value == 4,
            onClick = { selectedMenuItem.value = 4 }
        )
    }
}

