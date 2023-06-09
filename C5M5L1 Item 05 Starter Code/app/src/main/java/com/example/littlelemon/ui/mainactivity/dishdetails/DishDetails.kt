package com.example.littlelemon.ui.mainactivity.dishdetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.data.dishrepository.DishRepository
import com.example.littlelemon.R
import com.example.littlelemon.ui.topbar.TopAppBar
import com.example.littlelemon.ui.theme.LittleLemonColor

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DishDetails(id: Int) {
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
       ) {
        TopAppBar()
        GlideImage(model = dish.imageResource,
            contentDescription = "Dish image",
            modifier = Modifier.fillMaxWidth()
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)),
            contentScale = ContentScale.FillWidth
            )
        Column (
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)){
            Text(text = dish.name,
            style = MaterialTheme.typography.h1)
            Text(text = dish.description,
                style = MaterialTheme.typography.body1)
            Counter()
            Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .clip(shape = RoundedCornerShape(5.dp)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LittleLemonColor.yellow
            )
            ) {
                Text(text = stringResource(id = R.string.add_for) + " $${dish.price}",
                textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun Counter() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        var counter by remember {
            mutableStateOf(1)
        }
        TextButton(
            onClick = {
                counter--
            }
        ) {
            Text(
                text = "-",
                style = MaterialTheme.typography.h2
            )
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp)
        )
        TextButton(
            onClick = {
                counter++
            }
        ) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h2
            )
        }
    }
}

@Preview
@Composable
fun DishDetailsPreview() {
    DishDetails(id = 1)
}