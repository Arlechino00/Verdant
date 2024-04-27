package com.example.verdant.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.verdant.R
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.navigation.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(viewModel: AuthViewModel?, navController: NavController) {

    TopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.surface,
                    fontWeight = FontWeight.W500,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        },

        actions = {
            IconButton(onClick = {
                viewModel?.logout()
                navController.navigate(NavigationItem.Login.route) {
                    popUpTo(NavigationItem.Profile.route) { inclusive = true }
                }
            }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = "phone call",
                    tint = MaterialTheme.colorScheme.surface
                )
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
            NavigationItem.Profile
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