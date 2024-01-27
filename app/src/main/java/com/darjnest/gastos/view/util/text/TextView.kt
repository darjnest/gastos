package com.darjnest.gastos.view.util.text

import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TextViewPreview(){
    TextView()
}

@Composable
fun TextView(){

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "GASTOS",
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
    }

}