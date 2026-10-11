package com.mahrous.demo_app.core.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mahrous.demo_app.core.theme.AppCornerShape
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.core.theme.colorGrayTitleBold
import com.mahrous.demo_app.core.theme.colorRed
import com.mahrous.demo_app.core.theme.colorSilver
import com.mahrous.demo_app.core.theme.colorWhite

@Composable
fun TextAndIconWithBorder(
    painter: Painter,
    title: String = "",
    text1: String = "",
    text2: String = "",
    withIcon: Boolean = false,
    isRequired: Boolean = false,
    padding: Dp = AppMargin.dim16,
    iconSize: Dp = AppSize.size25,
    spacer: Dp = AppMargin.dim4,
    text1Style: TextStyle = MaterialTheme.typography.bodyLarge,
    text2Style: TextStyle = MaterialTheme.typography.bodyLarge,
    text1Color: Color = colorGrayTitleBold,
    text2Color: Color = colorGrayTitleBold,
    iconColor: Color = colorGrayTitleBold,
    onClick: () -> Unit,
) {

    Column {
        if (title.isNotEmpty()){
            Row {

                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.W900,
                        modifier = Modifier
//                    .fillMaxWidth()
                            .padding(horizontal = if (isRequired) 0.dp else padding),
                        color = MaterialTheme.colorScheme.onBackground,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,

                        )

                if (isRequired) {
                    Text(
                        text = " *",
                        style = MaterialTheme.typography.bodyMedium,
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
            Spacer( modifier = Modifier.padding(AppMargin.dim4))
        }

    Box(
        modifier = Modifier
            .height(AppSize.size48)
            .padding(padding)
            .fillMaxWidth()
            .clip(RoundedCornerShape(AppCornerShape.corner8))
            .background(
                shape = RoundedCornerShape(AppCornerShape.corner8),
                color = colorWhite
            )
            .border(
                width = 1.dp,
                color = colorSilver,
                shape = RoundedCornerShape(AppCornerShape.corner8)
            )
            .clickable {
                onClick()
            }
    ) {

        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = AppMargin.dim4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (withIcon) {
                Spacer( modifier = Modifier.padding(spacer))

                Icon(
                    painter = painter,
                    contentDescription = "",
                    tint = iconColor,
                    modifier = Modifier.size(iconSize)
                )

                Spacer(modifier = Modifier.padding(spacer))
            } else {
                Spacer(modifier = Modifier.padding(AppMargin.dim4))
            }
            Text(
                text = text1,
                modifier = Modifier
                    .padding(vertical = AppMargin.dim8),
                color = text1Color,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = text1Style,
            )

            if (text2.isNotEmpty()) {
                Spacer(modifier = Modifier.padding(spacer))
                Text(
                    text = text2,
                    modifier = Modifier
                        .padding(vertical = AppMargin.dim8),
                    color = text2Color,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = text2Style,
                )
            }

        }

    }
}
}