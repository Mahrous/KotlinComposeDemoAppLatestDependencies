package com.mahrous.demo_app.features.profile.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(


    ) : ViewModel() {


    var formState by mutableStateOf(ProfileState())




    fun onEvent(event: ProfileEvent) {
        viewModelScope.launch {
            when (event) {


                is ProfileEvent.ChangeDummy -> {
                    formState = formState.copy(dummy = event.dummy)
                }


            }
        }
    }




}

sealed class ProfileEvent {

    data class ChangeDummy(val dummy: String) : ProfileEvent()

}

data class ProfileState(
    val dummy: String = "Mahrous",


    )
