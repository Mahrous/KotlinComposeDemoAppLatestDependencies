package com.mahrous.demo_app.features.home.presentation.view

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.mahrous.demo_app.core.component.ComposableLifecycle
import com.mahrous.demo_app.features.main.MainEvent
import com.mahrous.demo_app.features.main.MainViewModel
import com.mahrous.demo_app.core.app.AppPreferences
import kotlinx.coroutines.CoroutineScope
import androidx.compose.material3.SnackbarHostState
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.messaging.FirebaseMessaging
import com.mahrous.demo_app.features.home.presentation.viewmodel.HomeEvent
import com.mahrous.demo_app.features.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    mainViewModel.onEvent(MainEvent.VisibleBottomNavigationChange(true))
    mainViewModel.onEvent(MainEvent.IndexBottomNavigationChange(0))


    BackHandler(true) {
        (context as Activity).finish()
    }

    ComposableLifecycle { source, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
                FirebaseMessaging.getInstance()
                    .token
                    .addOnSuccessListener {
                        Log.d("FCM", it)
                        Log.e("TAG", "HomeScreen: FCM = ${AppPreferences.getCurrentFCMToken()} ", )
                        if (AppPreferences.getCurrentFCMToken()!= it){
                        AppPreferences.storeCurrentFCMToken(it)
                        viewModel.onEvent(HomeEvent.UpdateFCMToken)
                        }
                    }
            }



            else -> {}

        }
    }


    Content(
        navController = navController,
//        viewModel = viewModel,
        mainViewModel = mainViewModel,
        paddingValues = paddingValues
    )
}


@Composable
private fun Content(
    navController: NavController,
//    viewModel: SignInViewModel,
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues
) {



}


