package com.mahrous.demo_app.features.profile.presentation.view

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.mahrous.demo_app.core.component.ComposableLifecycle
import com.mahrous.demo_app.features.main.MainEvent
import com.mahrous.demo_app.features.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import androidx.compose.material3.SnackbarHostState
import androidx.hilt.navigation.compose.hiltViewModel
import com.mahrous.demo_app.features.profile.presentation.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    viewModel: ProfileViewModel = hiltViewModel()

) {
    val context = LocalContext.current
    mainViewModel.onEvent(MainEvent.VisibleBottomNavigationChange(true))
    mainViewModel.onEvent(MainEvent.IndexBottomNavigationChange(3))


    ComposableLifecycle { source, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {

            }

            else -> {}

        }
    }


    Content(
        navController = navController,
        viewModel = viewModel,

    )
}


@Composable
private fun Content(
    navController: NavController,
    viewModel: ProfileViewModel

) {



}


