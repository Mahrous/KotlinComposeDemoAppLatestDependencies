package com.mahrous.demo_app.core.component.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.theme.*

/*
* background button is primary or secondary
*/
@Composable
fun CustomRectangleButtonWithText(
    onClick: () -> Unit,
    text: String,
    padding: Dp = AppMargin.dim16,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = colorWhite,
    withBorder: Boolean = false,
    coloBorder: Color = MaterialTheme.colorScheme.primary,
    withIcon: Boolean = false,
    withElevation: Boolean = true,
    icon: @Composable () -> Unit = {},
    enabled: Boolean = true,
    modifier: Modifier = Modifier.fillMaxWidth(),

    ) {
    Button(
        enabled = enabled,
        onClick = onClick,
        shape = RoundedCornerShape(AppCornerShape.corner12),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f)
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = if (!withElevation) 0.dp else AppElevation.elevation4
        ),
        modifier = if (withBorder) {
            modifier
                .padding(horizontal = padding)
                .height(AppSize.size50)
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(AppCornerShape.corner12),
                    color = coloBorder
                )
        } else {
            modifier
                .padding(horizontal = padding)
                .height(AppSize.size50)
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            if (withIcon){
                icon()
                Spacer(modifier = Modifier.padding(AppMargin.dim4))
            }

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                color = textColor)
        }

    }
}
