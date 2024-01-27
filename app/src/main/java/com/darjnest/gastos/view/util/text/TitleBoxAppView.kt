package com.darjnest.gastos.view.util.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.VerticalDivider


@Preview
@Composable
fun TitleBoxAppView(
    modifier: Modifier = Modifier,
    title:String = "",
    subTitle:String = "",
    colorBackground: Color = Color.LightGray
) {

    Box(
        modifier = modifier
            //.fillMaxWidth()
            //.height(100.dp)
            .background(
                color = colorBackground,
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 10.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 0.dp
                )
            )
            .size(width = 240.dp, height = 100.dp) // Set the size of the box as needed
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                modifier = Modifier.weight(0.3f),
                text = title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right
            )
            VerticalDivider(
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 20.dp)
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                modifier = Modifier.weight(0.3f).padding(end = 6.dp),
                text = subTitle,
                fontSize = 10.sp,
                color = Color.White,
                textAlign = TextAlign.Right,
                lineHeight = 10.sp
            )
        }
    }


}