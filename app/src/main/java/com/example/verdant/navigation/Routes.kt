package com.example.verdant.navigation

import com.example.verdant.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    data object Login: NavigationItem("login", R.drawable.ic_launcher_background, "Login")
    data object SignIn: NavigationItem("signin", R.drawable.ic_launcher_background, "SignIn")


    data object Home: NavigationItem("Acasa", R.drawable.home_icon, "Acasa")

    data object Discover: NavigationItem("Descoper", R.drawable.book_icon, "Descopera")
    data object PlantDetail: NavigationItem("Plantdetail", R.drawable.ic_launcher_background, "Plant Detail")

    data object Sherlock: NavigationItem("Sherlock", R.drawable.search_icon, "Sherlock")
    data object ImageClassifier: NavigationItem("ImageClassifier", R.drawable.ic_launcher_background, "ImageClassifier")
    data object Profile: NavigationItem("Profil", R.drawable.baseline_person_24, "Profil")
}