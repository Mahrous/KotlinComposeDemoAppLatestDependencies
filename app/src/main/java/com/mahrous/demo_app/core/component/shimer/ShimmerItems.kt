package com.mahrous.demo_app.core.component.shimer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import com.mahrous.demo_app.core.theme.AppCornerShape
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.AppSize

@Composable
fun ShimmerTransactionCard(brush: Brush) {
    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier
            .height(AppSize.size125)
            .fillMaxWidth()
            .padding(
                bottom = AppMargin.dim16,
                start = AppMargin.dim16,
                end = AppMargin.dim16
            )
            .clip(RoundedCornerShape(AppCornerShape.corner8))
            .background(brush),
    )
}