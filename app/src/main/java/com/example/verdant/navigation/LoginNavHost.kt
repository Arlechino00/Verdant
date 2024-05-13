package com.example.verdant.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.verdant.data.Plant
import com.example.verdant.data.local.Plants
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.login.ui.auth.LoginScreen
import com.example.verdant.login.ui.auth.SignupScreen
import com.example.verdant.ui.AI.AIUi
import com.example.verdant.ui.discover.Discover
import com.example.verdant.ui.discover.PlantDetail
import com.example.verdant.ui.discover.SetPlantDetails
import com.example.verdant.ui.home.HomeUI
import com.example.verdant.ui.profile.ProfileUI


@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route
) {
    val actions = remember(navController) { DiscoverActions(navController) }

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



        composable(NavigationItem.Home.route) {
            HomeUI()
        }

        composable(NavigationItem.Discover.route){
            Discover(selectedPlant = actions.selectedPlant)
        }

        composable(
            "${NavigationItem.PlantDetail}/{${"id"}}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            AnimatedVisibility(
                visible = true,
                enter = expandVertically(
                    expandFrom = Alignment.Top,
                    initialHeight = { 0 }
                )
            ) {
                PlantDetail(
                    id = arguments.getInt("id"),
                    navigateUp = actions.navigateUp
                )
            }

        }

        composable(NavigationItem.Sherlock.route){
            AIUi()
        }

        composable(NavigationItem.Profile.route) {
            ProfileUI(viewModel = viewModel, navController)
        }

    }
}

private class DiscoverActions(
    navController: NavHostController
) {
    val selectedPlant: (Int) -> Unit = { id: Int ->
        navController.navigate("${NavigationItem.PlantDetail.route}/$id")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}


