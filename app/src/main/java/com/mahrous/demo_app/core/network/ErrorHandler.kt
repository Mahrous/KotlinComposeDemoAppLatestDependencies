package com.mahrous.demo_app.core.network

import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.app.UiText

fun handleError(message: String): UiText {
    return when (message) {
        ConstantsErrorHandler.EXCEPTION_MESSAGE -> {
            UiText.StringResource(resId = R.string.strThereWasProblemConnecting)
        }
        ConstantsErrorHandler.NO_CONNECTION_INTERNET_MESSAGE -> {
            UiText.StringResource(resId = R.string.strThereIsNoInternetConnection)
        }
        else -> {
            UiText.StringResource(resId = R.string.strThereWasProblemConnecting)
        }
    }
}

object ConstantsErrorHandler {
    // Message Exception
    const val EXCEPTION_MESSAGE = "ExceptionMessage"
    const val NO_CONNECTION_INTERNET_MESSAGE = "NoConnectionInternetMessage"

    //endregion
}