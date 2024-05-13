package com.example.verdant.navigation

import com.example.verdant.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Login: NavigationItem("login", R.drawable.ic_launcher_background, "Login")
    data object SignIn: NavigationItem("signin", R.drawable.ic_launcher_background, "SignIn")


    data object Home: NavigationItem("Home", R.drawable.home_icon, "Home")

    data object Discover: NavigationItem("Discover", R.drawable.book_icon, "Discover")
    data object PlantDetail: NavigationItem("Plantdetail", R.drawable.ic_launcher_background, "Plant Detail")

    data object Sherlock: NavigationItem("Sherlock", R.drawable.search_icon, "Sherlock")
    data object Profile: NavigationItem("Profile", R.drawable.baseline_person_24, "Profile")
}