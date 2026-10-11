package com.mahrous.demo_app.features.rx_upload.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahrous.demo_app.core.app.AppPreferences

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RxUploadViewModel @Inject constructor(


    ) : ViewModel() {


    var formState by mutableStateOf(RxUploadState())




    fun onEvent(event: RxUploadEvent) {
        viewModelScope.launch {
            when (event) {


                is RxUploadEvent.ChangeDummy -> {
                    formState = formState.copy(dummy = event.dummy)
                }


            }
        }
    }




}

sealed class RxUploadEvent {

    data class ChangeDummy(val dummy: String) : RxUploadEvent()

}

data class RxUploadState(
    val dummy: String = "Mahrous",


    )
