package com.mahrous.demo_app.core.component.bottom_navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.features.main.MainViewModel

@Composable
fun CustomBottomNavigation(
    navController: NavController,
    viewModel: MainViewModel,
    onClickHome: () -> Unit,
    onClickCategories: () -> Unit,
    onClickRxUpload: () -> Unit,
    onClickProfile: () -> Unit,
) {

    val navBackStackEntry by
    navController.currentBackStackEntryAsState()

    val currentRoute =
        navBackStackEntry?.destination


    NavigationBar(

        containerColor =
            MaterialTheme.colorScheme.secondary,

        contentColor =
            MaterialTheme.colorScheme.onSecondary,

        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()

    ) {

        // =================================================
        // Home
        // =================================================

        NavigationBarItem(

            selected =
                viewModel.formState.currentIndexBottomNavigation == 0,

            onClick = onClickHome,

            icon = {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_home
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        AppSize.size25
                    )
                )
            },

            label = {

                ItemText(
                    title = stringResource(
                        id = R.string.strHome
                    )
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    MaterialTheme.colorScheme.primary,

                selectedTextColor =
                    MaterialTheme.colorScheme.primary,

                unselectedIconColor =
                    MaterialTheme.colorScheme.onBackground,

                unselectedTextColor =
                    MaterialTheme.colorScheme.onBackground,

                indicatorColor =
                    MaterialTheme.colorScheme.secondary
            )
        )



        NavigationBarItem(

            selected =
                viewModel.formState.currentIndexBottomNavigation == 1,

            onClick = onClickCategories,

            icon = {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_categories
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        AppSize.size25
                    )
                )
            },

            label = {

                ItemText(
                    title = stringResource(
                        id = R.string.strCategories
                    )
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    MaterialTheme.colorScheme.primary,

                selectedTextColor =
                    MaterialTheme.colorScheme.primary,

                unselectedIconColor =
                    MaterialTheme.colorScheme.onBackground,

                unselectedTextColor =
                    MaterialTheme.colorScheme.onBackground,

                indicatorColor =
                    MaterialTheme.colorScheme.secondary
            )
        )


        NavigationBarItem(

            selected =
                viewModel.formState.currentIndexBottomNavigation == 2,

            onClick = onClickRxUpload,

            icon = {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_rx_upload
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        AppSize.size25
                    )
                )
            },

            label = {

                ItemText(
                    title = stringResource(
                        id = R.string.strRxUpload
                    )
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    MaterialTheme.colorScheme.primary,

                selectedTextColor =
                    MaterialTheme.colorScheme.primary,

                unselectedIconColor =
                    MaterialTheme.colorScheme.onBackground,

                unselectedTextColor =
                    MaterialTheme.colorScheme.onBackground,

                indicatorColor =
                    MaterialTheme.colorScheme.secondary
            )
        )






        // =================================================
        // Profile
        // =================================================

        NavigationBarItem(

            selected =
                viewModel.formState.currentIndexBottomNavigation == 3,

            onClick = onClickProfile,

            icon = {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_profile
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(
                        AppSize.size25
                    )
                )
            },

            label = {

                ItemText(
                    title = stringResource(
                        id = R.string.strProfile
                    )
                )
            },

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    MaterialTheme.colorScheme.primary,

                selectedTextColor =
                    MaterialTheme.colorScheme.primary,

                unselectedIconColor =
                    MaterialTheme.colorScheme.onBackground,

                unselectedTextColor =
                    MaterialTheme.colorScheme.onBackground,

                indicatorColor =
                    MaterialTheme.colorScheme.secondary
            )
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ItemText(
    title: String
) {

    Text(
        text = title.uppercase(),

        style = MaterialTheme.typography.labelSmall,

        maxLines = 1,

        overflow = TextOverflow.Ellipsis,

        modifier = Modifier.basicMarquee(
            iterations = Int.MAX_VALUE
        )
    )
}