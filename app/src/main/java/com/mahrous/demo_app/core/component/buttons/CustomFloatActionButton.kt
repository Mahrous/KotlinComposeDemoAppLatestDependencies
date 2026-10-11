package com.mahrous.demo_app.core.component.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.app.AppPreferences
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.core.theme.AppTheme


/*
* background is secondary
*/
@Composable
fun CustomFloatActionButton(
    painter: Painter,
    iconColor: Color? = null,
    onClick: () -> Unit,
    iconSize: Dp = AppSize.size25,
    size: Dp = AppSize.size48,
    backgroundColor: Color = MaterialTheme.colorScheme.secondary,
    withBorder: Int = 2 // 0 -> with border 100%, 1 -> with border 10%, 2 -> without border
    ,modifier: Modifier=Modifier
) {

   val alpha = if (AppPreferences.getTheme()== AppTheme.Dark){
       0.1f
    } else{
       0.1f
   }
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        containerColor = backgroundColor,
        contentColor = backgroundColor,
        modifier = modifier
            .size(size)
            .border(
                width = 1.dp,
                shape = CircleShape,
                color = when (withBorder) {
                    0 -> MaterialTheme.colorScheme.primary
                    1 -> MaterialTheme.colorScheme.onPrimary.copy(alpha = alpha)
                    else -> backgroundColor
                }
            )
    ) {
        if (iconColor == null) {
            Image(
                painter = painter,
                contentDescription = "",
                modifier = Modifier.size(iconSize)
            )
        } else {
            Icon(
                painter = painter,
                contentDescription = "",
                tint = iconColor,
                modifier = Modifier.size(iconSize)
            )
        }

    }
}