package com.mahrous.demo_app.core.functions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.util.Patterns
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.app.Constants
import com.mahrous.demo_app.core.theme.AppCornerShape
import com.mahrous.demo_app.core.theme.AppSize
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil
import io.michaelrocks.libphonenumber.android.Phonenumber
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.util.Locale
import kotlin.text.drop
import kotlin.text.isEmpty
import kotlin.text.split
import kotlin.text.toInt
import kotlin.text.toLong


// this fun use for check if value is number
fun isNumber(value: String): Boolean {
    return value.isEmpty() || Regex("^\\d+\$").matches(value)
}


fun isEmailValid(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}


fun isValidPhoneWithCountryCode(phone: String, code: String, context: Context): Boolean {
    try {
        var withoutPlus = code.drop(1)
        var util: PhoneNumberUtil = PhoneNumberUtil.createInstance(context)
        val mobileNumber =
            Phonenumber.PhoneNumber().setCountryCode(withoutPlus.toInt())
                .setNationalNumber(phone.toLong())
        return util.isValidNumber(mobileNumber)
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }


}


fun hideKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = (context as Activity).currentFocus
    if (view != null) {
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}






fun Modifier.routate(
    isBackButton: Boolean
): Modifier =
    if (
        isBackButton &&
        AppPreferences.getLocale() == Constants.ARABIC_LOCALE_LANG
    ) {
        graphicsLayer { rotationZ = 180f }
    } else this






fun String.base64ToBitmap(): Bitmap? {
    return try {
        val pureBase64 = if (contains(",")) {
            substringAfter(",")
        } else {
            this
        }

        val bytes = Base64.decode(pureBase64, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    } catch (e: Exception) {
        null
    }
}

fun Context.shareText(text: String, title: String = "Share via") {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }

    startActivity(Intent.createChooser(intent, title))
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDateTime(dateTime: String): String {
    return try {
        val inputFormatter = DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd'T'HH:mm:ss")
            .optionalStart()
            .appendFraction(
                ChronoField.NANO_OF_SECOND,
                0,
                9,
                true
            )
            .optionalEnd()
            .toFormatter(Locale.ENGLISH)

        val outputFormatter = DateTimeFormatter.ofPattern(
            "yyyy MMM dd - hh:mm a",
            Locale.forLanguageTag(AppPreferences.getLocale())
        )

        LocalDateTime.parse(dateTime, inputFormatter)
            .format(outputFormatter)

    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(date: String): String {
    return try {
        val inputFormatter = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy",
            Locale.forLanguageTag(AppPreferences.getLocale())
        )

        val outputFormatter = DateTimeFormatter.ofPattern(
            "yyyy MMM dd",
            Locale.forLanguageTag(AppPreferences.getLocale())
        )

        LocalDate.parse(date, inputFormatter)
            .format(outputFormatter)

    } catch (e: Exception) {
        ""
    }
}

fun isNameContainJustLetterValidInput(text: String): Boolean {
    val regex = Regex("^[a-zA-Z\\u0621-\\u064A\\s]+$")
    return regex.matches(text)
}

fun Modifier.dashedBorder(
    color: Color =  Color(0xFF388E3C),
    cornerRadius: Dp = AppCornerShape.corner25,
    strokeWidth: Dp = AppSize.size1,
    dashWidth: Dp = AppSize.size4,
    dashGap: Dp = AppSize.size4
): Modifier = this.drawWithContent {
    drawContent()

    val strokePx = strokeWidth.toPx()
    val cornerRadiusPx = cornerRadius.toPx()
    val dashWidthPx = dashWidth.toPx()
    val dashGapPx = dashGap.toPx()

    val halfStroke = strokePx / 2f

    drawRoundRect(
        color = color,
        topLeft = androidx.compose.ui.geometry.Offset(halfStroke, halfStroke),
        size = androidx.compose.ui.geometry.Size(
            width = size.width - strokePx,
            height = size.height - strokePx
        ),
        style = Stroke(
            width = strokePx,
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashWidthPx, dashGapPx),
                phase = 0f
            )
        ),
        cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadiusPx)
    )
}

