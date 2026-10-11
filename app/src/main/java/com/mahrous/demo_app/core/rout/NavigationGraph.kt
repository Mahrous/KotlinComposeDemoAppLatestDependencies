package com.mahrous.demo_app.core.rout


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.features.auth.presentation.signin.view.SignInScreen
import com.mahrous.demo_app.features.categories.presentation.view.CategoriesScreen
import com.mahrous.demo_app.features.home.presentation.view.HomeScreen
import com.mahrous.demo_app.features.main.MainViewModel
import com.mahrous.demo_app.features.profile.presentation.view.ProfileScreen
import com.mahrous.demo_app.features.rx_upload.presentation.view.RxUploadScreen

import kotlinx.coroutines.CoroutineScope



@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    mainViewModel: MainViewModel,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    NavHost(
        navController = navHostController,
        startDestination = if (AppPreferences.getRememberMe() == true) AppScreen.HomeScreen.route else AppScreen.HomeScreen.route
    ) {


        composable(route = AppScreen.HomeScreen.route) {
            HomeScreen(
                navController = navHostController,
                paddingValues = paddingValues,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope
            )
        }

        composable(route = AppScreen.SignInScreen.route) {
            SignInScreen(
                navController = navHostController,
                paddingValues = paddingValues,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope
            )
        }


   composable(route = AppScreen.RxUploadScreen.route) {
            RxUploadScreen(
                navController = navHostController,
                paddingValues = paddingValues,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope
            )
        }


   composable(route = AppScreen.ProfileScreen.route) {
            ProfileScreen(
                navController = navHostController,
                paddingValues = paddingValues,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope
            )
        }


   composable(route = AppScreen.CategoriesScreen.route) {
            CategoriesScreen(
                navController = navHostController,
                paddingValues = paddingValues,
                mainViewModel = mainViewModel,
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope
            )
        }




    }




}