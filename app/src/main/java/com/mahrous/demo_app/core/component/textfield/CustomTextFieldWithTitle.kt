package com.mahrous.demo_app.core.component.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.UiText
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.AppText
import com.mahrous.demo_app.core.theme.colorRed

@Composable
fun CustomTextFieldWithTitle(
    modifier: Modifier = Modifier,
    placeholder: String,
    hint: String,
    onValueChange: (String) -> Unit = {},
    padding: Dp = AppMargin.dim16,
    errorMessage: UiText? = null,
    text: String = "",
    isError: Boolean = false,
    isPassword: Boolean = false,
    isRequired: Boolean = false,
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
    onCountryCodeChanged:(String)->Unit={},
    countryCode : String = AppPreferences.getCountryCode()
) {

    Column(modifier = modifier) {
        Row {
            if (placeholder.isNotEmpty()){
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodySmall.copy( fontSize = AppText.dim14),
                fontWeight = FontWeight.W900,
                modifier = Modifier
//                    .fillMaxWidth()
                    .padding(horizontal = if (isRequired) 0.dp else padding),
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,

                )
            }
            if (isRequired) {
                Text(
                    text = " *",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = AppText.dim14),
                    fontWeight = FontWeight.W900,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = padding),
                    color = colorRed,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,

                    )

            }
        }

        Spacer(modifier = Modifier.padding(AppMargin.dim2))


            CustomTextFieldApp(
                hint = hint,
                onValueChange = onValueChange,
                padding = padding,
                errorMessage = errorMessage,
                text = text,
                isError = isError,
                isPassword = isPassword,
                isEmail = isEmail,
                isText = isText,
                isPhone = isPhone,
                isNumber = isNumber,
                isDone = isDone,
                isVisible = isVisible,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                singleLine = singleLine,
                maxLine = maxLine
                , onCountryCodeChanged =
                {
                    onCountryCodeChanged(it)
                },
                countryCode = countryCode
            )


    }
}