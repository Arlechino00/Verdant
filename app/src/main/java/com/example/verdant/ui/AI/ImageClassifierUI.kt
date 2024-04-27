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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.verdant.R
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.navigation.NavigationItem
import com.example.verdant.ui.AddAppBar
import com.example.verdant.ui.BottomBar

@Composable
fun AIUi(){
    Text(text = "Image Classifier")
}

@Composable
fun AIButton(){
    Image(
        painter = painterResource(id = R.drawable.leaves_png_isolated_file),
        contentDescription = "")
}

