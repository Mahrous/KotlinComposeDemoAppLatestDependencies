package com.mahrous.demo_app.features.auth.presentation.signin.view

import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler

import androidx.compose.foundation.layout.*

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.mahrous.demo_app.core.component.ComposableLifecycle
import com.mahrous.demo_app.features.auth.presentation.signin.viewmodel.SignInEvent
import com.mahrous.demo_app.features.auth.presentation.signin.viewmodel.SignInViewModel
import com.mahrous.demo_app.features.main.MainViewModel
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.core.functions.hideKeyboard
import com.mahrous.demo_app.core.rout.AppScreen

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel(),
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope
) {
    val context = LocalContext.current
    val signInState = viewModel.signInState.value

    BackHandler(true) {
        (context as Activity).finish()
    }

    ComposableLifecycle { source, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE -> {
//                mainViewModel.onEvent(MainEvent.CheckUpdate)
                Log.d("TAG", "SignInScreen: onCreate")
            }

            Lifecycle.Event.ON_START -> {
                Log.d("TAG", "SignInScreen: ON_START")
            }

            Lifecycle.Event.ON_RESUME -> {
                Log.d("TAG", "SignInScreen: ON_RESUME")
            }

            Lifecycle.Event.ON_PAUSE -> {
                Log.d("TAG", "SignInScreen: ON_PAUSE")
            }

            Lifecycle.Event.ON_STOP -> {
//                viewModel.onDispose()
                Log.d("TAG", "SignInScreen: ON_STOP")
            }

            Lifecycle.Event.ON_DESTROY -> {
                Log.d("TAG", "SignInScreen: ON_DESTROY")
            }


            else -> {}

        }
    }

    LaunchedEffect(signInState) {
        when (signInState) {
            is DataState.Loading -> {
                hideKeyboard(context)
            }

            is DataState.Success -> {
                AppPreferences.storeCurrentUser(signInState.data , true)
                Log.e("TAG", "SignInScreen: ${signInState.data.accessToken}")
                AppPreferences.storeCurrentToken(signInState.data.accessToken)
                navController.navigate(AppScreen.HomeScreen.route) {
                    popUpTo(AppScreen.SignInScreen.route) {
                        inclusive = true
                    }
                }
                viewModel.onEvent(SignInEvent.Done)

            }

            is DataState.Failure -> {
                val message = signInState.message ?: signInState.uiText!!.asString(context)
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(message)
                }
            }


            else -> {}

        }
    }

    Content(
        navController = navController,
        viewModel = viewModel,
        mainViewModel = mainViewModel,
        paddingValues = paddingValues
    )
}






@Composable
private fun Content(
    navController: NavController,
    viewModel: SignInViewModel,
    mainViewModel: MainViewModel,
    paddingValues: PaddingValues
) {

    val context = LocalContext.current


}


