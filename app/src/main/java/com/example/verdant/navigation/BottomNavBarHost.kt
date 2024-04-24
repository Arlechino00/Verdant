package com.example.verdant.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.ui.home.ProfileScreen

@Composable
fun NavigationHost(
    viewModel: AuthViewModel?,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = NavigationItem.Profile.route) {
        composable(route = NavigationItem.Home.route) {
            //HomeScreen()
        }

        composable(
            route = NavigationItem.Discover.route
        ) {
            //NavigationGraph()
        }

        composable(
            route = NavigationItem.Sherlock.route
        ) {
            //AI()
        }

        composable(
            route = NavigationItem.Profile.route
        ) {
            ProfileScreen(viewModel, navController = navController)
        }
    }
}