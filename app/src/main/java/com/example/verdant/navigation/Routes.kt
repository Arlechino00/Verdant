package com.example.verdant.navigation

import com.example.verdant.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Login: NavigationItem("login", R.drawable.ic_launcher_background, "Login")
    data object SignIn: NavigationItem("signin", R.drawable.ic_launcher_background, "SignIn")


    data object Home: NavigationItem("home", R.drawable.home_icon, "Home")
    data object Discover: NavigationItem("discover", R.drawable.book_icon, "Discover")
    data object Sherlock: NavigationItem("sherlock", R.drawable.search_icon, "Sherlock")
    data object Profile: NavigationItem("profile", R.drawable.baseline_person_24, "Profile")
}