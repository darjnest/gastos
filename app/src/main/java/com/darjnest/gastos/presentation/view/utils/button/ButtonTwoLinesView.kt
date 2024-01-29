package com.darjnest.gastos.presentation.view.utils.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darjnest.gastos.ui.theme.RedHome

@Preview
@Composable
fun ButtonViewPreview() {
    ButtonTwoLinesView(
        text = "ADJUNTAR\n" +
                "IMAGENES",
        onClick = {}
    )
}

@Composable
fun ButtonTwoLinesView(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = RedHome,
    icon: ImageVector? = null,
    iconPainter: Painter? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        //.padding(bottom = 10.dp),
        shape = RoundedCornerShape(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        onClick = {
            onClick()
        }
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "...",
                tint = Color.White
            )
        }
        if (iconPainter != null) {
            Icon(
                painter = iconPainter,
                contentDescription = "...",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = text,
            fontSize = 11.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 12.sp


        )

    }
}