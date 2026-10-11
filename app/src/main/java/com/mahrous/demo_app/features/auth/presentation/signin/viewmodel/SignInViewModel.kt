package com.mahrous.demo_app.features.auth.presentation.signin.viewmodel

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.common.DataState
import com.mahrous.demo_app.features.auth.domain.model.Login
import com.mahrous.demo_app.features.auth.domain.model.User
import com.mahrous.demo_app.features.auth.domain.usecase.SignInUseCase
import com.mahrous.demo_app.features.auth.domain.usecase.ValidateEmailUseCase
import com.mahrous.demo_app.features.auth.domain.usecase.ValidatePhoneNumberUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val validateEmailUseCase: ValidateEmailUseCase,
    private val validatePhoneNumberUseCase: ValidatePhoneNumberUseCase,
    private val signInUseCase: SignInUseCase,

    ) : ViewModel() {


    var formState by mutableStateOf(SingInState())
    private val _signInState = mutableStateOf<DataState<User>>(DataState.Init)
    val signInState: State<DataState<User>> = _signInState

    var capturedImageUri by
    mutableStateOf<Uri>(Uri.EMPTY)


    fun onEvent(event: SignInEvent) {
        viewModelScope.launch {
            when (event) {

                is SignInEvent.EmailChanged -> {
                    formState = formState.copy(email = event.email)

                }
                is SignInEvent.PasswordChanged -> {
                    formState = formState.copy(password = event.password)

                }


                is SignInEvent.Submit -> {
                    if (validateEmail()) {
                        login()
                    }
                }
                is SignInEvent.Done -> {
                    _signInState.value = DataState.Init
                    formState = SingInState()
                }

            }
        }
    }

    private suspend fun login() {

        signInUseCase.execute(
            Login(
                email = formState.email,
                password = formState.password,

            )
        ).collect {
            _signInState.value = it

        }
    }

    private suspend fun validateEmail(): Boolean {
        val emailResult = validateEmailUseCase.execute(formState.email)
        formState = formState.copy(emailError = emailResult.errorMessage)
        return emailResult.successful
    }






}

sealed class SignInEvent {

    data class EmailChanged(val email: String) : SignInEvent()
    data class PasswordChanged(val password: String) : SignInEvent()
    object Submit : SignInEvent()
    data object Done : SignInEvent()

}

data class SingInState(
    val password: String = "",
    val passwordError: UiText? = null,
    val email: String = "",
    val emailError: UiText? = null,


    )
