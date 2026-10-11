@file:OptIn(ExperimentalAnimationApi::class)

package com.mahrous.demo_app.core.component.animation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlin.text.getOrNull
import kotlin.text.indices

@Composable
fun AnimatedCounter(
    count: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    color: Color = MaterialTheme.colorScheme.onBackground,
) {
    var oldCount by remember {
        mutableStateOf(count)
    }
    SideEffect {
        oldCount = count
    }
    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()
        for(i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]
            val char = if(oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = {
                    if ( targetState > initialState ){
                        ContentTransform(
                            targetContentEnter = slideInVertically { height -> height } + fadeIn(),
                            initialContentExit = slideOutVertically { height -> -height } + fadeOut()
                        )
                    } else {
                        ContentTransform(
                            targetContentEnter = slideInVertically { height -> -height } + fadeIn(),
                            initialContentExit = slideOutVertically { height -> height } + fadeOut()
                        )
                    }
                }
            ) {
                Text(
                    text = it.toString(),
                    style = style,
                    color = color,
                    softWrap = true
                )
            }
        }
    }
}