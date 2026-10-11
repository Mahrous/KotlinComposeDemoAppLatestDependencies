package com.mahrous.demo_app.core.component.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun CustomImage(
    url: String?,
    painter: Painter?,
    placeHolder: Int,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    if (url != null) {
        clear(context, url)
    }
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
        contentScale = contentScale,
        contentDescription = "",
        modifier = modifier
    )
}