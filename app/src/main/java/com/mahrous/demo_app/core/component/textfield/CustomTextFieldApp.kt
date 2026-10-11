package com.mahrous.demo_app.core.component.textfield

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.functions.*
import com.mahrous.demo_app.core.theme.*
import com.utkuglsvn.countrycodepicker.libData.utils.getLibCountries
import kotlin.collections.single
import kotlin.text.isEmpty

@Composable
fun CustomTextFieldApp1(
    placeholder: String,
    onValueChange: (String) -> Unit = {},
    padding: Dp = AppMargin.dim16,
    errorMessage: UiText? = null,
    text: String = "",
    isError: Boolean = false,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    isText: Boolean = false,
    isPhone: Boolean = false,
    isNumber: Boolean = false,
    isDone: Boolean = false,
    isVisible: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    maxLine: Int = 1,
    height: Dp = AppSize.size50,
) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val focusRequester = remember {
        FocusRequester()
    }

    Column {
        TextField(
            value = if (isPhone || isNumber) {
                if (isNumber(text)) text else ""
            } else text,
            onValueChange = {
                if (isPhone || isNumber) {
                    if (isNumber(it)) onValueChange(it)
                } else onValueChange(it)
            },
            placeholder = {
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.bodySmall,
                )
            },
            textStyle = MaterialTheme.typography.bodySmall,
            singleLine = singleLine,
            maxLines = maxLine,
            leadingIcon = leadingIcon, //Start
            trailingIcon = trailingIcon, //End
            interactionSource = interactionSource,
            visualTransformation =
            if (isPassword) {
                if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType =
                if (isPassword) KeyboardType.Password
                else if (isEmail) KeyboardType.Email
                else if (isText) KeyboardType.Text
                else if (isPhone) KeyboardType.Phone
                else if (isNumber) KeyboardType.Number
                else KeyboardType.Text,
                imeAction = if (isDone) ImeAction.Done else ImeAction.Next
            ),
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground,

                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(AppCornerShape.corner8),
            modifier =
            if (isFocused) {
                Modifier
                    .padding(horizontal = padding)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(AppCornerShape.corner8),
                        color = MaterialTheme.colorScheme.primary
                    )
                    .height(height)
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            } else if (isError) {
                Modifier
                    .padding(horizontal = padding)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(AppCornerShape.corner8),
                        color = MaterialTheme.colorScheme.error
                    )
                    .height(height)
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            } else {
                Modifier
                    .padding(horizontal = padding)
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(AppCornerShape.corner8),
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                    )
                    .height(height)
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
            },
        )
        Text(
            text = if (isError) errorMessage!!.asString(context) else "",
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding)
        )
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun CustomTextFieldApp(
    hint: String,
    onValueChange: (String) -> Unit = {},
    padding: Dp = AppMargin.dim16,
    errorMessage: UiText? = null,
    text: String = "",
    isError: Boolean = false,
    isPassword: Boolean = false,
    isEmail: Boolean = false,
    isText: Boolean = false,
    isPhone: Boolean = false,
    isNumber: Boolean = false,
    isDone: Boolean = false,
    isVisible: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    maxLine: Int = 1,
    height: Dp = AppSize.size50,
    onCountryCodeChanged: (String) -> Unit = {},
    countryCode: String = AppPreferences.getCountryCode()
) {
    var isFirstTime=true
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val focusRequester = remember {
        FocusRequester()
    }
    val countryCodePicker = MyCountryPicker()
    Column {

        BasicTextField(
            value = if (isPhone || isNumber) {
                if (isNumber(text)) text else ""
            } else text,
            onValueChange = {
                isFirstTime=false
                if (isPhone || isNumber) {
                    if (isNumber(it)) onValueChange(it)
                } else onValueChange(it)
            },
            textStyle = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface),
            maxLines = maxLine,
            singleLine = singleLine,
            interactionSource = interactionSource,
            visualTransformation =
            if (isPassword) {
                if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType =
                if (isPassword) KeyboardType.Password
                else if (isEmail) KeyboardType.Email
                else if (isText) KeyboardType.Text
                else if (isPhone) KeyboardType.Phone
                else if (isNumber) KeyboardType.Number
                else KeyboardType.Text,
                imeAction = if (isDone) ImeAction.Done else ImeAction.Next
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            decorationBox = { innerTextField ->
                Row(
                    modifier =
                    if (isFocused) {
                        Modifier
                            .padding(horizontal = padding)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(AppCornerShape.corner8),
                                color = colorSilver
                            )
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(AppCornerShape.corner8)
                            )
                            .height(height)
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                    } else if (isError  ) {
                        Modifier
                            .padding(horizontal = padding)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(AppCornerShape.corner8),
                                color = MaterialTheme.colorScheme.error
                            )
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(AppCornerShape.corner8)
                            )
                            .height(height)
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                    } else {
                        Modifier
                            .padding(horizontal = padding)
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(AppCornerShape.corner8),
                                color = colorSilver
                            )
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(AppCornerShape.corner8)
                            )
                            .height(height)
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isPhone) {
                        countryCodePicker.CountryCodeDialog(
                            pickedCountry = {
                                onCountryCodeChanged(it.countryPhoneCode)
                                isFirstTime=false

                                Log.e("TAG", "CustomTextFieldApp: isFocused = $isFocused", )
                            },
                            defaultSelectedCountry = getLibCountries().single {

                                when (countryCode) {

                                    "+20" -> {
                                        it.countryCode == "eg"
                                    }

                                    "+971" -> {
                                        it.countryCode == "ae"
                                    }

                                    "+966" -> {
                                        it.countryCode == "sa"
                                    }

                                    else -> {
                                        it.countryCode == "eg"
                                    }
                                }


                            },
                            dialogSearch = true,
                            dialogRounded = 22,
                            isOnlyFlagShow = false,
                            modifier = Modifier
                                .background(Color.Transparent)
                        )
                    }
                    if (leadingIcon != null) {
                        leadingIcon()
                    } else {
                        Spacer(modifier = Modifier.padding(AppMargin.dim8))
                    }

                    Box(modifier = Modifier.weight(1.0f)) {
                        if (height > 50.dp) {
                            if (text.isEmpty()) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(vertical = 16.dp),
                                    text = hint,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = colorSilver,
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(vertical = 16.dp)
                            ) {
                                innerTextField()
                            }
                        } else {
                            if (text.isEmpty()) {
                                Text(
                                    text = hint,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = colorSilver,
                                )
                            }
                            Box(modifier = Modifier.fillMaxWidth()) {
                                innerTextField()
                            }
                        }

                    }

                    if (trailingIcon != null) {
                        trailingIcon()
                    } else {
                        Spacer(modifier = Modifier.padding(AppMargin.dim8))
                    }
                }
            },
        )


        if (isError)
            Text(
                text = if (isError) errorMessage!!.asString(context) else "",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = padding)
            )
    }
}