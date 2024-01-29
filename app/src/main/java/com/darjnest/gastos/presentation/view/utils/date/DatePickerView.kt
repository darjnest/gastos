package com.darjnest.gastos.presentation.view.utils.date

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darjnest.gastos.ui.theme.InputBackground
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

@Preview
@Composable
fun DatePickerPreviewView() {
    DatePickerView(selectedValue = 0, onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerView(
    modifier: Modifier = Modifier,
    isValid: Boolean = true,
    selectedValue: Long,
    onValueChange: (Long) -> Unit,
) {

    var showDatePicker by remember { mutableStateOf(false) }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val today = Calendar.getInstance(TimeZone.getTimeZone("UTC")).apply {
                    set(Calendar.HOUR_OF_DAY, 0)
                    set(Calendar.MINUTE, 0)
                    set(Calendar.SECOND, 0)
                    set(Calendar.MILLISECOND, 0)
                }

                return utcTimeMillis <= today.timeInMillis
            }

            override fun isSelectableYear(year: Int): Boolean {
                return true
            }
        }
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = formatter.format(selectedValue).toString(),
            onValueChange = { },
            readOnly = true,
            label = {
                Text(
                    text = "FECHA",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            },
            textStyle = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold),
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showDatePicker = true },
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color.Black,
                focusedContainerColor = InputBackground,
                unfocusedContainerColor = InputBackground,
                disabledContainerColor = InputBackground,
                cursorColor = Color.Gray,
                focusedBorderColor = if (isValid) InputBackground else Color.Red,
                unfocusedBorderColor = if (isValid) InputBackground else Color.Red,
                disabledBorderColor = if (isValid) InputBackground else Color.Red,
            ),
            trailingIcon = {
                Icon(Icons.Default.DateRange, "", tint = Color.Gray)
            },
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



    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = {
                showDatePicker = false
            },
            confirmButton = {
                TextButton(onClick = {
                    showDatePicker = false
                    val selectedCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    if (datePickerState.selectedDateMillis == null) return@TextButton
                    selectedCalendar.timeInMillis = datePickerState.selectedDateMillis!!
                    selectedCalendar.set(Calendar.HOUR_OF_DAY, 0) // Establece la hora a 0
                    onValueChange(selectedCalendar.timeInMillis)
                }) {
                    Text(text = "Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                }) {
                    Text(text = "Cancelar")
                }
            }
        ) {
            DatePicker(
                state = datePickerState
            )
        }
    }
}
