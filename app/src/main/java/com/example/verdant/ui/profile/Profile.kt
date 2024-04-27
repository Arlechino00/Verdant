package com.example.verdant.ui.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.verdant.R
import com.example.verdant.login.ui.auth.AuthViewModel
import com.example.verdant.ui.theme.VerdantTheme
import com.example.verdant.ui.theme.spacing

@Composable
fun ProfileUI(
    viewModel: AuthViewModel?,
    navController: NavHostController
){
    Scaffold(
        content = { padding ->
            Surface(
                modifier = Modifier.padding(padding),
            ) {
                ProfileScreen(viewModel = viewModel)
            }
        },
        //bottomBar = { BottomBar(viewModel = viewModel, navController) }
    )
}


@Composable
fun ProfileScreen(viewModel: AuthViewModel?) {
    val spacing = MaterialTheme.spacing
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(spacing.medium)
            .padding(top = spacing.extraLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = viewModel?.currentUser?.displayName ?: "Guest",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSurface
        )

        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = stringResource(id = R.string.empty),
            modifier = Modifier.size(128.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(spacing.medium)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = stringResource(id = R.string.name),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.displayName ?: "Guest",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = stringResource(id = R.string.email),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.3f),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = viewModel?.currentUser?.email ?: "",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(0.7f),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }


        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    VerdantTheme {
        ProfileScreen(null)
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    VerdantTheme {
        ProfileScreen(null)
    }
}