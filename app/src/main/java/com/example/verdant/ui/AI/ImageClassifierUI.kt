package com.example.verdant.ui.AI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.verdant.R
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.navigation.NavigationHost
import com.example.verdant.navigation.NavigationItem
import com.example.verdant.ui.home.AddAppBar
import com.example.verdant.ui.theme.VerdantTheme

@Composable
fun AIUi(
    viewModel: AuthViewModel,
    navController: NavController
){
    Scaffold(
        topBar = { AddAppBar(viewModel, navController = navController) },
        content = { padding ->
            Surface(
                modifier = Modifier.padding(padding),
            ) {
                AIButton()

            }
        },
        bottomBar = {
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
                //val navController : NavHostController = rememberNavController()
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
}

@Composable
fun AIButton(){
    Image(
        painter = painterResource(id = R.drawable.leaves_png_isolated_file),
        contentDescription = "")
}

