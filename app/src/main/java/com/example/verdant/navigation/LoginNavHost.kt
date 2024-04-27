package com.example.verdant.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.login.ui.auth.LoginScreen
import com.example.verdant.login.ui.auth.SignupScreen
import com.example.verdant.ui.AI.AIUi
import com.example.verdant.ui.profile.ProfileUI


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(NavigationItem.Login.route) {
            LoginScreen(viewModel, navController)
        }
        composable(NavigationItem.SignIn.route) {
            SignupScreen(viewModel, navController)
        }



        composable(NavigationItem.Home.route){
            AIUi(viewModel = viewModel, navController)
        }

        composable(NavigationItem.Discover.route){
            AIUi(viewModel = viewModel, navController)
        }

        composable(NavigationItem.Sherlock.route){
            AIUi(viewModel = viewModel, navController)
        }

        composable(NavigationItem.Profile.route) {
            ProfileUI(viewModel = viewModel, navController)

        }

    }
}