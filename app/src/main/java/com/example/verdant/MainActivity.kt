package com.example.verdant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.verdant.login.data.Resource
import com.example.verdant.navigation.AppNavHost
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.ui.AddAppBar
import com.example.verdant.ui.BottomBar
import com.example.verdant.ui.theme.VerdantTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerdantTheme {
                val navController: NavHostController =  rememberNavController()
                val loginFlow = viewModel?.loginFlow?.collectAsState()
                if (loginFlow?.value is Resource.Success) {
                    Scaffold(
                        topBar = { AddAppBar( navController) },
                        content = { padding ->
                            Surface(
                                modifier = Modifier.padding(padding),
                            ) {
                                AppNavHost(viewModel, Modifier, navController)
                            }
                        },
                        bottomBar = { BottomBar(viewModel = viewModel, navController = navController) }
                    )
                }
                else {
                    Scaffold(
                        //topBar = { AddAppBar(viewModel, navController) },
                        content = { padding ->
                            Surface(
                                modifier = Modifier.padding(padding),
                            ) {
                                AppNavHost(viewModel, Modifier, navController)
                            }
                        },
                        //bottomBar = { BottomBar(viewModel = viewModel, navController = navController) }
                    )
                }

            }
        }
    }
}
