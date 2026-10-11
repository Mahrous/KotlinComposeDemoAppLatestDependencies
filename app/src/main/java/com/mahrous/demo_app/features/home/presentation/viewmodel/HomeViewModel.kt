package com.mahrous.demo_app.features.home.presentation.viewmodel

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.features.home.domain.usecase.UpdateFCMTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val updateFCMTokenUseCase: UpdateFCMTokenUseCase,

    ) : ViewModel() {


    var formState by mutableStateOf(HomeState())
    private val _updateFCMTokenState = mutableStateOf<DataState<Unit>>(DataState.Init)
    val updateFCMTokenState: State<DataState<Unit>> = _updateFCMTokenState

    var capturedImageUri by
    mutableStateOf<Uri>(Uri.EMPTY)


    fun onEvent(event: HomeEvent) {
        viewModelScope.launch {
            when (event) {

                is HomeEvent.UpdateFCMToken -> {

                    updateFCMToken()
                }


            }
        }
    }

    private suspend fun updateFCMToken() {

        updateFCMTokenUseCase.execute(Unit).collect {
            _updateFCMTokenState.value = it

        }
    }


}

sealed class HomeEvent {

    object UpdateFCMToken : HomeEvent()

}

data class HomeState(
    val currentFCMToken: String = AppPreferences.getCurrentFCMToken(),


    )
