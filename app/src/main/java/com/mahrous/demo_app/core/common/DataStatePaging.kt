package com.mahrous.demo_app.core.common

import  com.mahrous.demo_app.core.app.UiText

sealed class DataStatePaging<out R> {
    data class Success<out T>(val data: T) : DataStatePaging<T>()
    data class Failure(val message: String? = null, val uiText: UiText? = null) :
        DataStatePaging<Nothing>()
    object Loading : DataStatePaging<Nothing>()
    object NextLoading : DataStatePaging<Nothing>()
    object Init : DataStatePaging<Nothing>()

    //data class ExceptionState(val exception:): DataState<Nothing>()
}