package com.darjnest.gastos.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Crear una clase de datos para manejar el tamaño en unidades Dp
data class DpSize(val width: Dp, val height: Dp)

// Una función de extensión Composable para obtener las dimensiones de la pantalla en Dp
@Composable
fun rememberScreenSize(): DpSize {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    return remember(configuration) { DpSize(screenWidth, screenHeight) }
}