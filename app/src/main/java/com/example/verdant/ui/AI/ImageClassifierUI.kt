package com.example.verdant.ui.AI

import android.Manifest
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.verdant.R
import com.example.verdant.navigation.NavigationItem
import com.example.verdant.ui.AI.components.CameraView
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState
import com.google.mlkit.vision.label.ImageLabel

@Composable
fun AIUi(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer), verticalArrangement = Arrangement.Center){
        AIButton(
            onCardClick = { navController.navigate(NavigationItem.ImageClassifier.route) })
    }
    //ImageLabelingScreen(navController = navController)
}

@Composable
fun AIButton(onCardClick: () -> Unit){
    val scroll = rememberScrollState()

    Column(verticalArrangement = Arrangement.Center) {
        Card(
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        ) {
            Column(
                modifier = Modifier
                    .clickable(onClick = onCardClick)
                    .verticalScroll(state = scroll),
                verticalArrangement = Arrangement.Bottom,

                ) {
                Image(
                    painter = rememberImagePainter("https://developers.google.com/static/ml-kit/vision/image-labeling/images/image_labeling2x.png"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(300.dp)
                        .clip(RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp))
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(R.string.desription_ai),
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ImageLabelingScreen(navController: NavController) {
    val context = LocalContext.current
    val cameraPermissionState =
        rememberPermissionState(permission = Manifest.permission.CAMERA)

    PermissionRequired(
        permissionState = cameraPermissionState,
        permissionNotGrantedContent = {
            LaunchedEffect(Unit) {
                cameraPermissionState.launchPermissionRequest()
            }
        },
        permissionNotAvailableContent = {
            Column {
                Toast.makeText(context, "Permission denied.", Toast.LENGTH_LONG).show()
            }
        }) {
        ScanSurface(navController = navController)

    }
}

@Composable
fun ScanSurface(navController: NavController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val imageLabels = remember { mutableStateListOf<ImageLabel>() }

    Box(modifier = Modifier.fillMaxSize()) {
        CameraView(
            context = context,
            lifecycleOwner = lifecycleOwner,
            analyzer = ImageLabelingAnalyzer {
                imageLabels.clear()
                imageLabels.addAll(it)
            }
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight()
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.8f)
                    .height(150.dp),
            ) {
                Text(
                    text = imageLabels.joinToString(separator = "\n") { it.text },
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .padding(10.dp),
                    maxLines = 3
                )
            }
        }
    }
}

