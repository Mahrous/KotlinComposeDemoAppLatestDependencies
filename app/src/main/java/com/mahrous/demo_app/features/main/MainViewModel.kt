package com.mahrous.demo_app.features.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.Constants
import com.mahrous.demo_app.core.theme.AppTheme

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(


) : ViewModel() {

    var formState by mutableStateOf(MainState())





    fun onEvent(event: MainEvent) {
        viewModelScope.launch {
            when (event) {



                is MainEvent.ThemeChange -> {
                    formState = formState.copy(theme = event.theme)
                }


                is MainEvent.VisibleBottomNavigationChange -> {
                    formState =
                        formState.copy(isBottomNavigationVisible = event.isBottomNavigationVisible)
                    formState = formState.copy(currentStatusBar = event.currentStatusBar)
                }
                is MainEvent.IndexBottomNavigationChange -> {
                    formState =
                        formState.copy(currentIndexBottomNavigation = event.currentIndexBottomNavigation)
                }



            }
        }
    }





}

sealed class MainEvent {
    data class ThemeChange(val theme: AppTheme) : MainEvent()

    data class VisibleBottomNavigationChange(
        val isBottomNavigationVisible: Boolean,
        val currentStatusBar: Int = 0
    ) : MainEvent()

    data class IndexBottomNavigationChange(val currentIndexBottomNavigation: Int) : MainEvent()



}

data class MainState(

    val theme: AppTheme = AppPreferences.getTheme(),
    val isBottomNavigationVisible: Boolean = false,
    val currentIndexBottomNavigation: Int = Constants.HIDE_BOTTOM_NAVIGATION,
    val currentStatusBar: Int = 0,
    )

data class OrderDeliveredResponseDTO(
    val data: Boolean
)