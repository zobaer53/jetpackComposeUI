package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp

@Composable
fun LowerPanel() {
    Column {
        WeeklySpecial()
        MenuDish()
    }
}


@Composable
fun WeeklySpecial(){
    // to be defined
    Card(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(text = "Weekly Special",
            fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        modifier = Modifier
            .padding(8.dp))

    }
}


@Composable
fun MenuDish() {
    // to be defined
    Card() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            Column() {
                Text(text = "Greek Salad",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)

                Text(text = "The famous Greek salad of"+
                        " crispy lettuce, peppers, olives, "+
                        "our Chicago ...",
                    color = Color.Gray,
                    modifier = Modifier
                        .paddingFromBaseline(bottom = 5.dp)
                        .fillMaxWidth(.75f)
                )
                Text(text = "$12.99",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp))
            }
            Image(painter = painterResource(id = R.drawable.greeksalad),
                contentDescription = "Greek Salad Image")
        }

    }
    Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp
    )
}



@Preview(showBackground = true)
@Composable
fun LowerPanelPreview(){
    LowerPanel()
}
