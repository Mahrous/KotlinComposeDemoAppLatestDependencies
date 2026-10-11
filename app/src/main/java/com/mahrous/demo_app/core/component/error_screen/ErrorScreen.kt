package com.mahrous.demo_app.core.component.error_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.mahrous.demo_app.R
import com.mahrous.demo_app.core.theme.AppMargin
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.core.theme.colorBlack
import com.mahrous.demo_app.core.theme.colorGray
import com.mahrous.demo_app.core.theme.colorHint

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    imgResource: Int = R.drawable.wifi_error_img/*wifi_error_img*/,
    descResource: Int = R.string.strThereIsNoInternetConnection,
    title: Int = R.string.error
) {
    Column(
        modifier = modifier.padding(AppMargin.dim16)
            .background( color = MaterialTheme.colorScheme.background, shape = RectangleShape)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = imgResource), contentDescription = "" )
        Spacer(modifier = modifier.size(AppMargin.dim16))
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.bodyMedium,
            color = colorBlack,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = modifier.size(AppMargin.dim8))
        Text(
            text = stringResource(descResource),
            style = MaterialTheme.typography.bodySmall,
            color = colorHint,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}



@Composable
fun EmptyData(
    modifier: Modifier,
    painter: Painter,
    text: String,
    text2: String
)
{
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(AppSize.size250)
        )

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppMargin.dim20)
        )
        Spacer(modifier = Modifier.padding(AppMargin.dim4))
        Text(
            text = text2,
            style = MaterialTheme.typography.bodySmall,
            color = colorGray.copy(.5f),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppMargin.dim20)
        )
        Spacer(modifier = Modifier.padding(AppMargin.dim20))
    }
}