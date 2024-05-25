package com.example.verdant.ui.discover

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.verdant.R
import com.example.verdant.data.Plant
import com.example.verdant.data.local.Plants
import com.example.verdant.ui.AddAppBar
@Composable
fun Discover(
    selectedPlant: (Int) -> Unit,
    navController: NavController,
    searchTextState: String
) {
        PlantList(
            searchTextState,
            selectedPlant,
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantCard(
    dataItem: Plant,
    selectedPlant: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .shadow(
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)), // Use rounded corners
                elevation = 5.dp,
                ambientColor = Color(0x33000000)
            )
            //.padding(top = 3.dp)
        ,
        elevation = CardDefaults.cardElevation(2.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary),
        onClick = {selectedPlant(dataItem.id)}
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
                contentDescription = dataItem.name,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    //.size(dimensionResource(id = R.dimen.card_width))
                    .weight(0.6f)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = dataItem.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.header_content_padding_vertical))
                        .fillMaxWidth()
                        //.weight(1f)
                )
                Text(
                    text = dataItem.category,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.header_content_padding_vertical))
                        .fillMaxWidth()
                        //.weight(1f)
                )
            }


        }
    }
}


@Composable
fun PlantList(
    searchTextState: String,
    selectedPlant: (Int) -> Unit,
    modifier: Modifier
) {
    val scrollState = rememberLazyListState()
    val context = LocalContext.current
    val plants: List<Plant> = Plants.getPlantsList(context)

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.detail_card_list_padding_top)/2),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(id = R.dimen.list_item_horizontal_spacing)),
        state = scrollState
    ) {
        items(
            items = plants
                .filter { it.name.contains(searchTextState,ignoreCase = true) || it.category.contains(searchTextState, ignoreCase = true) },
            key = {plants -> plants.id}
        ) { plant ->
            when (plant.id) {
                0 -> {
                    PlantCard(
                        dataItem = plant,
                        selectedPlant,
                        Modifier.padding(top = dimensionResource(R.dimen.detail_card_list_padding_top), bottom = dimensionResource(R.dimen.detail_card_list_padding_top)/2))
                }
                35 -> {
                    PlantCard(
                        dataItem = plant,
                        selectedPlant,
                        Modifier.padding(bottom = dimensionResource(R.dimen.detail_card_list_padding_top), top = dimensionResource(R.dimen.detail_card_list_padding_top)))
                }
                else -> {
                    PlantCard(
                        dataItem = plant,
                        selectedPlant,
                        Modifier.padding(vertical = dimensionResource(R.dimen.detail_card_list_padding_top)/2)

                    )
                }
            }
        }
    }
}
