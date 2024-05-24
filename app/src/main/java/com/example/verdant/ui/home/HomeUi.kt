package com.example.verdant.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.verdant.R
import com.example.verdant.data.Plant
import com.example.verdant.data.local.Plants
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.navigation.NavigationItem

@Composable
fun HomeUI(viewModel: AuthViewModel?, navController: NavController){
    Column {
        Header(viewModel)
        HomeSpacer()
        Explore(navController)
        HomeSpacer()
        ToSherlock(navController = navController)
    }
}

@Composable
fun HomeSpacer(){
    Card(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.spacer))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ){
        Text(text = "")
    }
}

@Composable
fun Header(viewModel: AuthViewModel?){
    Box(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.card_width))
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = stringResource(id = R.string.welcome_back),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.surface
            )

            Text(
                text = (viewModel?.currentUser?.displayName ?: "Guest") + "!",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.surface
            )
        }

    }
}

@Composable
fun Explore(navController: NavController){
    val context = LocalContext.current
    val plants: List<Plant> = Plants.getPlantsList(context)

    Card(
        Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.text_padding),
                horizontal = dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal)
            )
            .clickable { navController.navigate(NavigationItem.Discover.route) },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = "Află mai multe ...",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.W600,
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.text_padding))
                .padding(horizontal = dimensionResource(id = R.dimen.text_padding))
            )

        LazyRow(
            Modifier
                .padding(vertical = dimensionResource(id = R.dimen.text_padding)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.detail_card_list_padding_top)/2),

            ) {
            items(items = plants.filter { it.id < 6 }) {
                if (it.id == 0){
                    PlantRowPhoto(it, Modifier.padding(start = dimensionResource(id = R.dimen.text_padding)))

                }
                else{
                    PlantRowPhoto(it, Modifier)
                }
            }
        }
    }
}

@Composable
fun PlantRowPhoto(
    plant: Plant,
    modifier: Modifier
){
    Column(
        modifier = Modifier
            .size(170.dp)

    ){
        Image(
            painter = painterResource(plant.photo),
            contentDescription = plant.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.text_padding) / 2)
                .fillMaxSize()
                .clip(RoundedCornerShape(50))
        )

        Text(
            text = plant.name,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun ToSherlock(navController: NavController){
    Card(
        Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.text_padding),
                horizontal = dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal)
            )
            .clickable { navController.navigate(NavigationItem.ImageClassifier.route) },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
    ){
        Text(
            text = "Incearcă modelul AI",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.W600,
            modifier = Modifier
                .padding(top = dimensionResource(id = R.dimen.text_padding))
                .padding(horizontal = dimensionResource(id = R.dimen.text_padding))
        )
        Icon(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = "Sherlock",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.text_padding) / 2)
                .fillMaxSize()
        )
    }
}