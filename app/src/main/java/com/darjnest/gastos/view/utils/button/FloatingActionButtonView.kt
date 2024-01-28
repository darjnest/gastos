package com.darjnest.gastos.view.utils.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun FloatingActionButtonViewPreview() {
    FloatingActionButtonView()
}

@Composable
fun FloatingActionButtonView() {

    var expanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (expanded) 45f else 0f,
        animationSpec = tween(durationMillis = 300), label = ""
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        SmallFloatingActionButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.padding(end = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Expand options",
                modifier = Modifier.rotate(rotation)
            )
        }

        AnimatedVisibility(visible = expanded) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.Bottom)
            ) {
                SmallFloatingActionButton(onClick = {})
                {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Map")
                }
                SmallFloatingActionButton(onClick = {})
                {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Agregar")
                }
                SmallFloatingActionButton(onClick = {})
                {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Delete")
                }
            }
        }
    }
}