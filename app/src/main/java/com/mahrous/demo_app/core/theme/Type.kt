package com.mahrous.demo_app.core.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Typography
import com.mahrous.demo_app.R


// =====================================================
// Fonts
// =====================================================

val fontPoppins = FontFamily(
    Font(R.font.poppins_regular)
)

val fontCairo = FontFamily(
    Font(R.font.cairo_regular)
)


private fun appTextStyle(
    fontSize: androidx.compose.ui.unit.TextUnit,
    fontWeight: FontWeight,
    fontFamily: FontFamily
): TextStyle {

    return TextStyle(
        fontWeight = fontWeight,
        fontSize = fontSize,
        fontFamily = fontFamily,
        fontStyle = FontStyle.Normal,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        )
    )
}


val TypographyEn = Typography(

    displayLarge = appTextStyle(fontSize = AppText.dim28, fontWeight = FontWeight.W900, fontFamily = fontPoppins), // Big word

    displayMedium = appTextStyle(fontSize = AppText.dim24, fontWeight = FontWeight.W900, fontFamily = fontPoppins), //Medial word

    displaySmall = appTextStyle(fontSize = AppText.dim16, fontWeight = FontWeight.W900, fontFamily = fontPoppins), // big Screen title

    titleLarge = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W900, fontFamily = fontPoppins), // All entire large titles

    titleMedium = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W600, fontFamily = fontPoppins), // All entire Medium titles

    titleSmall = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W500, fontFamily = fontPoppins), // All entire details

    bodyLarge = appTextStyle(fontSize = AppText.dim10, fontWeight = FontWeight.W600, fontFamily = fontPoppins), //  All entire small details

    bodyMedium = appTextStyle(fontSize = AppText.dim10, fontWeight = FontWeight.W400, fontFamily = fontPoppins), //  All entire very small details

    bodySmall = appTextStyle(fontSize = AppText.dim8, fontWeight = FontWeight.W400, fontFamily = fontPoppins), //  All entire small and thin details

    labelLarge = appTextStyle(fontSize = AppText.dim14, fontWeight = FontWeight.W700, fontFamily = fontPoppins), // Buttons large

    labelSmall = appTextStyle( fontSize = AppText.dim10, fontWeight = FontWeight.W500, fontFamily = fontPoppins), // buttons small

    headlineMedium = appTextStyle(fontSize = AppText.dim14, fontWeight = FontWeight.W600, fontFamily = fontPoppins),

    headlineSmall = appTextStyle(fontSize = AppText.dim16, fontWeight = FontWeight.W600, fontFamily = fontPoppins),
)


// =====================================================
// Arabic Typography
// =====================================================

val TypographyAr = Typography(

    displayLarge = appTextStyle(fontSize = AppText.dim28, fontWeight = FontWeight.W900, fontFamily = fontCairo), // Big word

    displayMedium = appTextStyle(fontSize = AppText.dim24, fontWeight = FontWeight.W900, fontFamily = fontCairo), //Medial word

    displaySmall = appTextStyle(fontSize = AppText.dim16, fontWeight = FontWeight.W900, fontFamily = fontCairo), // big Screen title

    titleLarge = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W900, fontFamily = fontCairo), // All entire large titles

    titleMedium = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W600, fontFamily = fontCairo), // All entire Medium titles

    titleSmall = appTextStyle(fontSize = AppText.dim12, fontWeight = FontWeight.W500, fontFamily = fontCairo), // All entire details

    bodyLarge = appTextStyle(fontSize = AppText.dim10, fontWeight = FontWeight.W600, fontFamily = fontCairo), //  All entire small details

    bodyMedium = appTextStyle(fontSize = AppText.dim10, fontWeight = FontWeight.W400, fontFamily = fontCairo), //  All entire very small details

    bodySmall = appTextStyle(fontSize = AppText.dim8, fontWeight = FontWeight.W400, fontFamily = fontCairo), //  All entire small and thin details
    headlineMedium = appTextStyle(
        fontSize = AppText.dim14,
        fontWeight = FontWeight.W600,
        fontFamily = fontCairo
    ),

    headlineSmall = appTextStyle(
        fontSize = AppText.dim16,
        fontWeight = FontWeight.W600,
        fontFamily = fontCairo
    ),

    labelSmall = appTextStyle(
        fontSize = AppText.dim10,
        fontWeight = FontWeight.W500,
        fontFamily = fontCairo
    )
)