package com.mahrous.demo_app.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import  com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.component.error_screen.ErrorScreen
import  com.mahrous.demo_app.core.theme.AppMargin
import  com.mahrous.demo_app.core.theme.AppSize
import  com.mahrous.demo_app.R
import com.mahrous.demo_app.core.theme.AppText
import com.mahrous.demo_app.core.theme.colorBlack
import com.mahrous.demo_app.core.theme.noColorBackGround


@Composable
fun ErrorStateScreen(
    uiText: UiText? = null,
    message: String? = null
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize().background(noColorBackGround),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.wifi_error_img),
            contentDescription = null,
            modifier = Modifier.size(AppSize.size200)
        )

        val _message = message ?: uiText!!.asString(context)
        Text(
            text = _message,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppMargin.dim20),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(fontSize = AppText.dim14),
            color = colorBlack
        )
    }
}

@Composable
fun CustomLoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun CustomLoadingDialog(
    setShowDialog: (Boolean) -> Unit,
    returnValue: (Boolean) -> Unit
) {
    Dialog(
        onDismissRequest = { setShowDialog(false) },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(MaterialTheme.colorScheme.surface)
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(AppMargin.dim16)
            )
        }
    }
}


@Composable
fun EmptyStateScreen(
    text: String ,
    painter: Painter
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(AppSize.size200)
        )

        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppMargin.dim20),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(fontSize = AppText.dim14),
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun DataState<*>.ContentScreen(
    returnIsDone: (Boolean) -> Unit = {},
    returnIsError: (Boolean) -> Unit = {},
    isDialog: Boolean = false,
    loading: @Composable () -> Unit = { CustomLoadingState() },
    error:@Composable ()->Unit = {
        ErrorScreen(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()))
    },
    content: @Composable (Any?) -> Unit = {},

    ) {
    val isShow = remember {
        mutableStateOf(false)
    }
    when (this) {
        is DataState.Init -> {
            content(null)
        }
        is DataState.Loading -> {
            if (isDialog) {
                CustomLoadingDialog(
                    setShowDialog = { isShow.value },
                    returnValue = {}
                )
            } else {
                loading()
            }
        }
        is DataState.Success<*> -> {
            returnIsDone(true)
            returnIsError(false)
            content(this.data)
        }
        is DataState.Failure -> {
            returnIsDone(false)
            returnIsError(true)
//            CustomErrorState(uiText = this.uiText, message = this.message)
            error()
        }
    }
}