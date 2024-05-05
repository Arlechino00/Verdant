package com.example.verdant.ui.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.verdant.api.discovery.model.Plant
import com.example.verdant.api.discovery.model.PlantItem

@Composable
fun Discover() {

    //Text(text = "Plant List")
    PlantList()
}

@Composable
fun PlantCard(dataItem: PlantItem) {
    Box(
        Modifier
            .height(200.dp)
            .background(Color.Transparent)
            .padding(horizontal = 6.dp)

    ) {
        Box(
            modifier = Modifier
                .background(Color.Cyan, shape = RoundedCornerShape(20.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .align(Alignment.BottomCenter)

        ) {
            Text(
                text = dataItem.commonName ?: "Error",
                maxLines = 1,
                style = TextStyle(

                    fontSize = if (dataItem.commonName == "Controller") {
                        60.sp
                    } else {
                        70.sp
                    },
                    letterSpacing = 20.sp,
                    color = Color.White.copy(alpha = 0.1f),
                ),
                modifier = Modifier.align(
                    Alignment.Center
                )

            )

        }
        Image(
            contentScale = ContentScale.Fit,
            painter = rememberAsyncImagePainter(dataItem.defaultImage?.originalUrl),
            contentDescription = null,
            modifier = Modifier

                .align(Alignment.CenterStart)
                .graphicsLayer {
                    translationY = (-50).toFloat()
                    translationX = (-100).toFloat()
                }
                .padding(start = 10.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 40.dp)
        ) {
            Text(
                dataItem.commonName ?: "Error",
                fontSize = 30.sp,
                color = Color.White,

                )
            Row {
                Text("")
            }
        }
    }
}

@Composable
fun PlantList() {
    val viewModel: PlantViewModel = viewModel()
    val PlantsData = viewModel.plantsData
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(count = PlantsData.value.size) {
            PlantCard(PlantsData.value[it])
        }

    }
}
