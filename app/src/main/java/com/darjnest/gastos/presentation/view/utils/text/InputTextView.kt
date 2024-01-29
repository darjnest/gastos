package com.darjnest.gastos.presentation.view.utils.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darjnest.gastos.ui.theme.InputBackground

@Preview
@Composable
fun InputTextViewPreview() {
    InputTextView(selectedValue = "", onValueChange = {})
}

@Composable
fun InputTextView(
    hint: String = "",
    singleLine: Boolean = true,
    modifier: Modifier = Modifier,
    isValid: Boolean = true,
    selectedValue: String,
    onValueChange: (String) -> Unit,
) {

    Column {

        OutlinedTextField(
            value = selectedValue,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = hint,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            },
            singleLine = singleLine,
            maxLines = 3,
            modifier = modifier
                .fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color.Black,
                focusedContainerColor = InputBackground,
                unfocusedContainerColor = InputBackground,
                disabledContainerColor = Color.White,
                cursorColor = Color.Black,
                focusedBorderColor = if (isValid) InputBackground else Color.Red,
                unfocusedBorderColor = if (isValid) InputBackground else Color.Red,
                disabledBorderColor = if (isValid) InputBackground else Color.Red,
            )
        )

        if (!isValid) {
            Text(
                text = "Campo obligatorio",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }


}