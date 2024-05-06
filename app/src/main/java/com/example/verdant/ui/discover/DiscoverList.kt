package com.example.verdant.ui.discover

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.verdant.R
import com.example.verdant.data.Plant

@Composable
fun Discover() {
    val viewModel: PlantViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    PlantList(plant = uiState.plantList, onClick = { /*TODO*/ })
}

@Composable
fun PlantCard(dataItem: Plant, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .shadow(
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)), // Use rounded corners
                elevation = 5.dp,
                ambientColor = Color(0x33000000))
        ,
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_width))
                .background(color = MaterialTheme.colorScheme.onPrimary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(dataItem.photo),
                contentDescription = dataItem.name ?: "Error",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .size(dimensionResource(id = R.dimen.card_width))
                    .weight(0.4f)
            )

                Text(
                    text = dataItem.name ?: "Error",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.header_content_padding_vertical))
                        .fillMaxWidth()
                        .weight(1f)
                )


        }
    }
}


@Composable
fun PlantList(
    plant: List<Plant>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: PlantViewModel = viewModel()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.detail_card_list_padding_top)),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = plant, key = { plant -> plant.id }) { plant ->
            PlantCard(dataItem = plant)
        }
    }
}
