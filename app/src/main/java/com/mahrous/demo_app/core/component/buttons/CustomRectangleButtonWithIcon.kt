package com.mahrous.demo_app.core.component.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.functions.routate
import com.mahrous.demo_app.core.theme.*

/*
* background button is primary or secondary
*/
@Composable
fun CustomRectangleButtonWithIcon(
    painter: Painter,
    iconColor: Color? = null,
    onClick: () -> Unit,
    iconSize: Dp = AppSize.size15,
    size: Dp = AppSize.size40,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    withBorder: Int = 0, // 0 -> with border 100%, 1 -> with border 10%, 2 -> without border

    isBackButton: Boolean = false,
    modifier:Modifier= Modifier

) {
    val alpha = if (AppPreferences.getTheme()== AppTheme.Dark){
        0.5f
    } else{
        0.1f
    }
    Card(
        colors = CardDefaults.cardColors( containerColor = backgroundColor),
        shape = RoundedCornerShape(AppCornerShape.corner8),
        border = BorderStroke(
            width = 1.dp,
            color = when (withBorder) {
                0 -> MaterialTheme.colorScheme.onBackground
                1 -> iconColor!!.copy(alpha =alpha)
                else -> backgroundColor
            },
        ),

        modifier = modifier

//            .shadow(
//                elevation = AppElevation.elevation4,
//                shape = RectangleShape
//            )
            .size(size)
            .clip(RoundedCornerShape(AppCornerShape.corner8))
            .clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painter,
                contentDescription = "",
                tint = iconColor!!,
                modifier = Modifier
                    .size(iconSize)
                    .routate(isBackButton)
            )
        }
    }
}