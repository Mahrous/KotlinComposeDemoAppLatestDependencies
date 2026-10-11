package com.mahrous.demo_app.core.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.mahrous.demo_app.core.theme.AppSize

/*
* when you need load image from internet send url
* and when you need load image from drawable send painter
*/
@Composable
fun CustomCircleImage(
    size: Dp = AppSize.size40,
    painter: Painter? = null,
    url: String? = null,
    onClick: () -> Unit,
    placeHolder: Int
) {
    val context = LocalContext.current
    if (url != null) {
        clear(context, url)
    }

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(size)
            .clickable (
                interactionSource = remember { MutableInteractionSource() },
                indication = null){
                onClick()
            }
    ) {
        val image = painter
            ?: rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .diskCacheKey(url)
                    .memoryCacheKey(url)
                    .data(url)
                    .build(),
                placeholder = painterResource(id = placeHolder),
                error = painterResource(id = placeHolder),
            )

        Image(
            painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)

        )
    }
}