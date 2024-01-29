package com.darjnest.gastos.presentation.view.utils.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.darjnest.gastos.presentation.view.utils.text.TitleBoxAppView

@Composable
fun HeaderView(
    marginTop: Dp = 0.dp,
    title: String,
    subTitle: String,
    tipe: String,
    imageResource: Int

) {
    Row(
        modifier = Modifier
            .padding(top = marginTop)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
    ) {
        TitleBoxAppView(
            modifier = Modifier.weight(1.5f),
            title = title,
            subTitle = subTitle,
            colorBackground = Color.Gray
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            //.padding(end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = "",
                modifier = Modifier.height(60.dp)
            )
            Text(
                text = tipe,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}