package com.ElOuedUniv.maktaba.presentation.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Pink60,
    onPrimary = White,
    primaryContainer = Dark60,
    onPrimaryContainer = Pink80,
    secondary = Pink40,
    onSecondary = White,
    background = Dark90,
    onBackground = White,
    surface = Dark80,
    onSurface = White,
    surfaceVariant = Dark60,
    onSurfaceVariant = LightGray
)

private val LightColorScheme = lightColorScheme(
    primary = Pink40,
    onPrimary = White,
    primaryContainer = LightPink,
    onPrimaryContainer = Pink40,
    secondary = Pink60,
    onSecondary = White,
    background = Dark90,
    onBackground = White,
    surface = Dark80,
    onSurface = White,
    surfaceVariant = Dark60,
    onSurfaceVariant = LightGray
)

@Composable
fun MaktabaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Dark90.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}