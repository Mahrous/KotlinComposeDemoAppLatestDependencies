package com.mahrous.demo_app.features.main


import android.Manifest
import android.R
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.updatePadding
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.Constants
import com.mahrous.demo_app.core.component.bottom_navigation.CustomBottomNavigation
import com.mahrous.demo_app.core.rout.AppScreen

import com.mahrous.demo_app.core.rout.NavigationGraph
import com.mahrous.demo_app.core.theme.AppCornerShape
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.DemoAppTheme
import com.mahrous.demo_app.core.theme.colorWhite

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import java.util.Locale
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        askNotificationPermission()

        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
        }
        setStatusBarTextColor(this, true)

        setContent {
            DemoAppTheme(AppPreferences.getTheme()) {
                val navController = rememberNavController()

                val coroutineScope = rememberCoroutineScope()
                val layoutDirection =
                    if (AppPreferences.getLocale() == Constants.ARABIC_LOCALE_LANG)
                        LocalLayoutDirection provides LayoutDirection.Rtl
                    else
                        LocalLayoutDirection provides LayoutDirection.Ltr


                val context = LocalContext.current

                val snackbarHostState = remember {
                    SnackbarHostState()
                }


                CompositionLocalProvider(layoutDirection) {
                    Scaffold(

                        modifier = Modifier.navigationBarsPadding(),
                        bottomBar = {
                            if (viewModel.formState.isBottomNavigationVisible) {

                                BottomAppBar(
                                    modifier = Modifier
                                        .height(65.dp),
                                    containerColor = colorWhite,
                                    contentPadding = PaddingValues(),
                                    tonalElevation = 0.dp,
                                ) {
                                    CustomBottomNavigation(
                                        navController = navController,
                                        viewModel = viewModel,

                                        onClickHome = {
                                            if (viewModel.formState.currentIndexBottomNavigation != 0) {
                                                navController.navigate(
                                                    AppScreen.HomeScreen.route
                                                )
                                            }
                                        },

                                        onClickCategories = {
                                            if (viewModel.formState.currentIndexBottomNavigation != 1) {
                                                navController.navigate(
                                                    AppScreen.CategoriesScreen.route
                                                )
                                            }
                                        },

                                        onClickRxUpload = {
                                            if (viewModel.formState.currentIndexBottomNavigation != 2) {
                                                navController.navigate(
                                                    AppScreen.RxUploadScreen.route
                                                )
                                            }
                                        },

                                        onClickProfile = {
                                            if (viewModel.formState.currentIndexBottomNavigation != 3) {
                                                navController.navigate(
                                                    AppScreen.ProfileScreen.route
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        },
                        snackbarHost = {
                            SnackbarHost(
                                hostState = snackbarHostState
                            ) { data ->
                                CustomSnackBar(data.visuals.message)
                            }
                        },
                        floatingActionButtonPosition = FabPosition.Center,

                    )
                    { innerPadding ->
                        Box {

                            Body(
                                modifier = Modifier.padding(innerPadding),
                                innerPadding,
                                navController = navController,
                                viewModel,
                                coroutineScope,
                                snackbarHostState
                            )
                        }
                    }
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content)) { view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
        }

    }


    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {

        } else {

            askNotificationPermission()
        }
    }


    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                Log.e("TAG", "askNotificationPermission:PERMISSION_GRANTED ")
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                Log.e("TAG", "askNotificationPermission:shouldShowRequestPermissionRationale ")

            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                Log.e("TAG", "askNotificationPermission:requestPermissionLauncher ")
            }
        }
    }


    override fun attachBaseContext(newBase: Context) {
        val appLang = AppPreferences.getLocale()
        val newOverride = Configuration(newBase.resources.configuration)
        val context = setAppLocal(newBase, appLang)
        super.attachBaseContext(context)
    }

    private fun setAppLocal(mContext: Context, localCode: String): Context {
        var context = mContext
        val res = context.resources
        val configuration = res.configuration
        configuration.setLocale(Locale(localCode.lowercase(Locale.getDefault())))
        context = mContext.createConfigurationContext(configuration)
        return context
    }

}


@Composable
private fun CustomSnackBar(
    message: String
) {
    Snackbar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppMargin.dim16),

        shape = RoundedCornerShape(
            AppCornerShape.corner8
        ),

        containerColor = MaterialTheme.colorScheme.primary,

        contentColor = colorWhite
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Body(
    modifier: Modifier,
    paddingValues: PaddingValues,
    navController: NavHostController,
    mainViewModel: MainViewModel,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState,
) {
    NavigationGraph(
        navController,
        paddingValues,
        mainViewModel,
        coroutineScope,
        snackbarHostState = snackbarHostState
    )
}

fun setStatusBarTextColor(activity: Activity, darkText: Boolean) {
    val window = activity.window
    WindowCompat.setDecorFitsSystemWindows(window, false)

    val controller = WindowInsetsControllerCompat(window, window.decorView)
    controller.isAppearanceLightStatusBars = darkText
}
