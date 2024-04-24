package com.example.verdant.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.login.ui.auth.LoginScreen
import com.example.verdant.login.ui.auth.SignupScreen
import com.example.verdant.navigation.BottomNavBar
import com.example.verdant.navigation.NavigationItem
import com.example.verdant.ui.VerdantApp
import com.example.verdant.ui.home.ProfileScreen


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationItem.Profile.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        navigation(
            startDestination = startDestination,
            route = NavigationItem.Auth.route
        ){
            composable(NavigationItem.Auth.Login.route) {
                LoginScreen(viewModel, navController)
            }
            composable(NavigationItem.Auth.SignIn.route) {
                SignupScreen(viewModel, navController)
            }
        }

        composable(NavigationItem.Profile.route) {
            VerdantApp(viewModel = viewModel, navController)

        }

        composable(NavigationItem.Home.route){

        }

        composable(NavigationItem.Discover.route){

        }

        composable(NavigationItem.Sherlock.route){
            
        }



    }
}