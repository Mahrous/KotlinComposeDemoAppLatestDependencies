package com.mahrous.demo_app.core.component.image

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import coil.memory.MemoryCache
import coil.request.ImageRequest
import com.mahrous.demo_app.core.theme.AppSize
import com.mahrous.demo_app.R

/*
* must size1 >  size2
* this component use when you need 2 borders for image
* when you need load image from internet send url
* and when you need load image from drawable send painter
*/
@Composable
fun CustomCircleImageWithBorder(
    size1: Dp = AppSize.size150,
    size2: Dp = AppSize.size140,
    painter: Painter? = null,
    url: String? = null,
    onClick: () -> Unit,
    colorBorder1: Color = MaterialTheme.colorScheme.primary,
    colorBorder2: Color = MaterialTheme.colorScheme.background,
    borderSize:Int=4
) {
    val context = LocalContext.current
    val placeHolder = R.drawable.img_male_place_holder

    if (url != null) {
        clear(context, url)
    }
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(size1)
            .border(width = borderSize.dp, color = colorBorder1, shape = CircleShape)
    ) {
        val image = painter ?: rememberAsyncImagePainter(
            model = ImageRequest.Builder(context).diskCacheKey(url).memoryCacheKey(url).data(url)
                .build(),
            placeholder = painterResource(id = placeHolder),
            error = painterResource(id = R.drawable.img_male_place_holder),
        )

        Image(painter = image,
            contentScale = ContentScale.Crop,
            contentDescription = "image",
            modifier = Modifier
                .clip(CircleShape)
                .size(size2)
                .border(
                    width = borderSize.dp, color = colorBorder2, shape = CircleShape
                )
                .align(Alignment.Center)
                .clickable {
                    onClick()
                })

    }
}

@OptIn(ExperimentalCoilApi::class)
fun clear(context: Context, url: String) {
    val imageLoader = context.imageLoader
    if (imageLoader.memoryCache?.keys?.contains(MemoryCache.Key(url)) == true) {
        imageLoader.diskCache?.remove(url)
        imageLoader.memoryCache?.remove(MemoryCache.Key(url))
    }
}