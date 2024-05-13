package com.example.verdant.ui.discover

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.verdant.R
import com.example.verdant.data.Plant
import com.example.verdant.data.local.Plants
import kotlinx.coroutines.FlowPreview
import androidx.compose.material3.TopAppBar as TopAppBar1

@OptIn(FlowPreview::class)
@Composable
fun PlantDetail(
    id: Int,
    navigateUp: () -> Unit,

){
    val context = LocalContext.current

    val plant: Plant = remember(id){
        Plants.getPlant(
            id, context
        )
    }


    AnimatedVisibility(
        visible = true,
        enter = expandVertically(
            expandFrom = Alignment.Top,
            initialHeight = { 0 }
        )
    ) {
        SetPlantDetails(plant, navigateUp)
    }

}

@Composable
fun SetPlantDetails(
    plant: Plant,
    navigateUp: () -> Unit
){
    val scroll = rememberScrollState()

    Surface {
        Box(
            modifier = Modifier
                .verticalScroll(state = scroll)
        ){
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
            ) {
                PlantImage(plant, navigateUp)
                Details(plant)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantImage(
    plant: Plant,
    navigateUp: () -> Unit,
){
    val filter = ColorFilter.tint(Color.Black, BlendMode.DstAtop)

    Box(Modifier.padding(dimensionResource(id = R.dimen.detail_card_outer_padding_horizontal))) {
        Image(
            painter = painterResource(id = plant.photo),
            contentDescription = plant.name,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)))
            ,
            contentScale = ContentScale.Crop,
            colorFilter = filter
        )

    }
}

@Composable
fun Details(plant: Plant){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.detail_expanded_subject_body_spacing))
            .shadow(
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)), // Use rounded corners
                elevation = 5.dp,
                ambientColor = Color(0x33000000)
            )
            ,
        elevation = CardDefaults.cardElevation(),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.list_item_inner_padding)),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.onPrimary)
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
        ) {

            Name(plant = plant)
            Category(plant = plant)
            if (plant.poisonous != null){
                Poisonous(plant = plant)
            }
            if (plant.medicinal != null){
                Medicinal(plant = plant)
            }
            Description(plant = plant)
            if (plant.warning != null){
                Warning(plant = plant)
            }
        }
    }
}

@Composable
fun Name(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Nume",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = plant.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}

@Composable
fun Category(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Categorie",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = plant.category,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}

@Composable
fun Poisonous(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Efecte",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = stringResource(plant.poisonous!!),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}

@Composable
fun Medicinal(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Beneficii",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = stringResource(plant.medicinal!!),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}

@Composable
fun Description(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Scurta descriere",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = stringResource(plant.description!!),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}

@Composable
fun Warning(plant: Plant){
    Column(
        Modifier
            .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))
    ) {
        Text(
            text = "Efecte",
            fontWeight = FontWeight.W600,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
        Text(
            text = stringResource(plant.warning!!),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.list_item_horizontal_spacing))

        )
    }
}