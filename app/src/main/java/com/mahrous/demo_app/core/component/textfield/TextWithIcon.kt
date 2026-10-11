package com.mahrous.demo_app.core.component.textfield

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.core.theme.colorGrayTitleBold

@Composable
public fun TextWithIcon(
    painter: Painter,
    text: String,
    iconSize : Dp = AppSize.size25 ,
    spacer : Dp = AppMargin.dim4 ,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    textColor: Color = colorGrayTitleBold,
    iconColor: Color = colorGrayTitleBold,
    onClick: () -> Unit = {},

    ) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painter,
            contentDescription = "",
            tint = iconColor,
            modifier = Modifier.size(iconSize)
        )

        Spacer(modifier = Modifier.padding(spacer))
        Text(
            text = text,
            modifier = Modifier,
            color = textColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = textStyle,
        )

    }

}



//            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//
//                Icon(
//                    modifier = Modifier.size(AppSize.size20),
//                    painter = painterResource(id = R.drawable.ic_calender),
//                    contentDescription = "calender",
//                    tint = colorPrimary
//                )
//                Spacer(
//                    modifier = Modifier.width(AppMargin.dim8)
//                )
//
//                Text(
//                    text = "Date Range",
//                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.W900),
//                    color = Color(0xFF1A1747)
//                )
//
//            }
