package com.darjnest.gastos.view.util.logo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darjnest.gastos.R

@Preview
@Composable
fun LogoViewPreview(){
    LogoView()
}

@Composable
fun LogoView(modifier: Modifier = Modifier) {

    BoxWithConstraints(modifier = Modifier) {
        val isLargeScreen = maxHeight > 600.dp
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.gastos),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .size(if (isLargeScreen) 40.dp else 40.dp)
            )
        }
    }
}