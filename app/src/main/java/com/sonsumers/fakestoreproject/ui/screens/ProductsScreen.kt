package com.sonsumers.fakestoreproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonsumers.fakestoreproject.R

@Preview
@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.sample_jp),
                contentDescription = "Sample",
                modifier = Modifier.size(250.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Product Name", style = TextStyle(fontSize = 18.sp))
            Text(text = "Product Description")
            Text(text = "Category")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Pricing",
                modifier = Modifier
                    .weight(1f)
                    .padding(0.dp, 8.dp),
                style = TextStyle(fontSize = 18.sp)
            )
            Button(onClick = {

            }) {
                Text(text = "Add to cart")
            }
        }
    }
}