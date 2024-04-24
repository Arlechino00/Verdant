package com.example.verdant.navigation

import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.verdant.login.navigation.AppNavHost
import com.example.verdant.login.ui.auth.AuthViewModel

@Composable
fun BottomNavBar(
    viewModel: AuthViewModel,
){
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Discover,
        NavigationItem.Sherlock,
        NavigationItem.Profile
    )
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.scrim)
            ) {
                val navController : NavHostController = rememberNavController()
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
                        })
                }
            }
        }
    )
    { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)

        ) {

            AppNavHost(viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    //BottomNavBar(null)
}