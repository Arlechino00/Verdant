package com.example.verdant.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.verdant.R
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.navigation.NavigationItem
import com.example.verdant.ui.discover.PlantViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar( navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                if(currentRoute == "PlantDetail/{id}"){
                    Text(
                        "Back",
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.W500,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
                   else {
                    Text(
                        currentRoute.toString(),
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.W500,
                        style = MaterialTheme.typography.headlineMedium
                    )
                   }
            }
        },
        navigationIcon = {
            if (currentRoute == "PlantDetail/{id}" || currentRoute == NavigationItem.Profile.route) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.surface,

                    )
                }
            }
        },
        
        actions = {
                if(currentRoute != NavigationItem.Profile.route) {
                    IconButton(onClick = {
                        navController.navigate(NavigationItem.Profile.route)
                    }
                    ) {
                        Icon(
                            painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "logout",
                            modifier = Modifier
                                .size(30.dp),
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primary),
    )
}


@Composable
fun BottomBar(viewModel: AuthViewModel?, navController: NavController){
    NavigationBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.scrim)
    ) {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Discover,
            NavigationItem.Sherlock,
            //NavigationItem.Profile
        )
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { it ->
            NavigationBarItem(selected = currentRoute == it.route,
                label = {
                    Text(
                        text = it.title,
                    )
                },
                icon = {
                    Icon(
                        ImageVector.vectorResource(it.icon), contentDescription = null,
                        //tint = MaterialTheme.colorScheme.
                    )

                },

                onClick = {
                    if (currentRoute != it.route) {

                        navController.graph.startDestinationRoute?.let {
                            navController.popBackStack(it, true)
                        }

                        navController.navigate(it.route) {
                            launchSingleTop = true

                        }
                    }
                },
            )
        }
    }
}