package com.mahrous.demo_app.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(

    primary = colorPrimary,

    secondary = colorWhite,

    background = colorBackGroundLight,

    surface = colorWhite,

    error = colorRed,

    onPrimary = colorBlack,

    onBackground = colorBlack,

    onSecondary = colorMineShaft,

    onSurface = colorEmperor,

    onError = colorWhite
)


private val LightColorScheme = lightColorScheme(

    primary = colorPrimary,

    secondary = colorWhite,

    background = colorBackGroundLight,

    surface = colorWhite,

    error = colorRed,

    onPrimary = colorBlack,

    onBackground = colorBlack,

    onSecondary = colorMineShaft,

    onSurface = colorEmperor,

    onError = colorWhite
)


@Composable
fun DemoAppTheme(
    theme: AppTheme,
    isSystemInDarkTheme: Boolean = isSystemInDarkTheme(),
    isArabic: Boolean = false,
    content: @Composable () -> Unit
) {

    val colorScheme = when (theme) {

        AppTheme.Default -> {
            if (isSystemInDarkTheme) {
                DarkColorScheme
            } else {
                LightColorScheme
            }
        }

        AppTheme.Dark -> {
            DarkColorScheme
        }

        AppTheme.Light -> {
            LightColorScheme
        }
    }


    val typography = if (isArabic) {
        TypographyAr
    } else {
        TypographyEn
    }


    MaterialTheme(

        colorScheme = colorScheme,

        typography = typography,

        shapes = Shapes,

        content = content
    )
}


enum class AppTheme {
    Light,
    Dark,
    Default
}