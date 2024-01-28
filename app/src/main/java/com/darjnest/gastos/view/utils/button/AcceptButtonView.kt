package com.darjnest.gastos.view.utils.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darjnest.gastos.ui.theme.Green

@Preview
@Composable
fun AcceptButtonViewPreview() {
    AcceptButtonView(onAttachImages = { /*TODO*/ }, onSaveAndSend = { /*TODO*/ }) {
    }
}

@Composable
fun AcceptButtonView(
    onAttachImages: () -> Unit,
    onSaveAndSend: () -> Unit,
    onBack: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        ButtonTwoLinesView(
            text = "ADJUNTAR RECIBO",
            color = Color.Gray,
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp)
        ) {
            onAttachImages()
        }
        ButtonTwoLinesView(
            text = "GUARDAR ENTRADA",
            color = Green,
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
        ) {
            onSaveAndSend()
        }

        Spacer(modifier = Modifier.weight(0.1f))


    }

}