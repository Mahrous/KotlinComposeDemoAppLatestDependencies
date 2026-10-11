package com.mahrous.demo_app.features.categories.presentation.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(


    ) : ViewModel() {


    var formState by mutableStateOf(CategoriesState())




    fun onEvent(event: CategoriesEvent) {
        viewModelScope.launch {
            when (event) {


                is CategoriesEvent.ChangeDummy -> {
                    formState = formState.copy(dummy = event.dummy)
                }


            }
        }
    }




}

sealed class CategoriesEvent {

    data class ChangeDummy(val dummy: String) : CategoriesEvent()

}

data class CategoriesState(
    val dummy: String = "Mahrous",


    )
