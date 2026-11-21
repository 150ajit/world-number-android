package com.example.worldpopulation.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun LiveCounterDisplay(
    title: String,
    population: Long,
    subtitle: String = "Estimated live population",
    formatType: NumberFormatType = NumberFormatType.INTERNATIONAL,
    animateTransitions: Boolean = true,
    modifier: Modifier = Modifier
) {
    val formatted = NumberFormatter.format(population, formatType)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
        tonalElevation = 2.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                )
                .padding(vertical = 24.dp, horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(EmeraldGreen.copy(alpha = 0.2f))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "LIVE",
                            color = EmeraldGreen,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = title.uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clipToBounds(),
                    contentAlignment = Alignment.Center
                ) {
                    val density = LocalDensity.current
                    val fontScale = density.fontScale.coerceAtLeast(1.0f)
                    val charCount = formatted.length.coerceAtLeast(10)
                    // Monospace character width is ~0.60em. To guarantee 0% overflow/wrapping on any screen width or font scale:
                    val calculatedSp = ((maxWidth.value * 0.88f) / (charCount * 0.60f * fontScale))
                        .coerceIn(16f, 30f)
                    val responsiveFontSize = calculatedSp.sp

                    if (animateTransitions) {
                        key(formatType, formatted.length) {
                            Row(
                                modifier = Modifier
                                    .clipToBounds()
                                    .padding(vertical = 2.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val chars = formatted.toList()
                                chars.forEachIndexed { index, char ->
                                    val reverseIndex = chars.size - 1 - index
                                    key(reverseIndex) {
                                        if (char.isDigit()) {
                                            AnimatedContent(
                                                targetState = char,
                                                transitionSpec = {
                                                    (slideInVertically(
                                                        animationSpec = tween(260, easing = FastOutSlowInEasing)
                                                    ) { height -> height } +
                                                     fadeIn(animationSpec = tween(180)))
                                                        .togetherWith(
                                                            slideOutVertically(
                                                                animationSpec = tween(260, easing = FastOutSlowInEasing)
                                                            ) { height -> -height } +
                                                            fadeOut(animationSpec = tween(180))
                                                        )
                                                },
                                                modifier = Modifier.clipToBounds(),
                                                label = "Digit_$reverseIndex"
                                            ) { digitChar ->
                                                Text(
                                                    text = digitChar.toString(),
                                                    fontSize = responsiveFontSize,
                                                    fontWeight = FontWeight.Black,
                                                    fontFamily = FontFamily.Monospace,
                                                    color = CyanAccent,
                                                    maxLines = 1,
                                                    softWrap = false,
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        } else {
                                            Text(
                                                text = char.toString(),
                                                fontSize = responsiveFontSize,
                                                fontWeight = FontWeight.Black,
                                                fontFamily = FontFamily.Monospace,
                                                color = CyanAccent,
                                                maxLines = 1,
                                                softWrap = false,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        Text(
                            text = formatted,
                            fontSize = responsiveFontSize,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Monospace,
                            color = CyanAccent,
                            maxLines = 1,
                            softWrap = false,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
