package com.example.verdant.ui.discover

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.verdant.api.discovery.model.PlantItem

@Composable
fun Discover() {

    //Text(text = "Plant List")
    PlantList()
}

@Composable
fun PlantCard(dataItem: PlantItem, modifier: Modifier = Modifier) {
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
                painter = rememberAsyncImagePainter(dataItem.defaultImage?.mediumUrl),
                contentDescription = dataItem.commonName ?: "Error",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .size(dimensionResource(id = R.dimen.card_width))
                    .weight(0.4f)
            )

                Text(
                    text = dataItem.commonName ?: "Error",
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
fun PlantItemPhoto(dataItem: PlantItem, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {

    }
}

@Composable
fun PlantList() {
    val viewModel: PlantViewModel = viewModel()
    val pl = viewModel.plantsData
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(count = pl.value.size) {
            if(it !=0)
                PlantCard(pl.value[it], modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal)))
            else             PlantCard(pl.value[it], modifier = Modifier.padding(top = dimensionResource(id = R.dimen.card_space)))


        }

    }
}
