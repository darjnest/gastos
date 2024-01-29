package com.darjnest.gastos.presentation.view.utils.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darjnest.gastos.presentation.view.utils.icon.CircleIconText

@Preview(showBackground = true)
@Composable
fun BackButtonViewPreview() {
    BackButtonView(onClick = {})
}

@Composable
fun BackButtonView(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .heightIn(max = 50.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .height(50.dp)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CircleIconText(
                icono = Icons.AutoMirrored.Filled.ArrowBack,
                color = Color.Gray,
                colorIcon = Color.White
            ) {
                onClick()
            }
            Spacer(modifier = Modifier.padding(horizontal = 6.dp))
            Text(
                text = "VOLVER",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Gray
            )

        }
    }

}