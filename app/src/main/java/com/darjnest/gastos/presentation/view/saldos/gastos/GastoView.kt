package com.darjnest.gastos.presentation.view.saldos.gastos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.darjnest.gastos.R
import com.darjnest.gastos.presentation.util.rememberScreenSize
import com.darjnest.gastos.presentation.view.utils.button.AcceptButtonView
import com.darjnest.gastos.presentation.view.utils.date.DatePickerView
import com.darjnest.gastos.presentation.view.utils.header.HeaderView
import com.darjnest.gastos.presentation.view.utils.text.InputTextView
import com.darjnest.gastos.presentation.viewmodel.saldos.gastos.GastoViewModel


@Preview
@Composable
fun GastoViewPreview() {
    GastoView(id = "", navController = rememberNavController())
}

@Composable
fun GastoView(
    id: String,
    navController: NavController,
    viewModel: GastoViewModel = hiltViewModel()
) {

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {

        val sizeDivice = rememberScreenSize()
        var marginTop = sizeDivice.width * 0.10f

        var isUploadImage by rememberSaveable {
            mutableStateOf(false)
        }
        val formState = viewModel.formValidationState


        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            HeaderView(
                title = "SALIDA",
                subTitle = "GASTOS DE DINERO",
                tipe = "",
                imageResource = R.drawable.entrada,
                marginTop = marginTop
            )

            Spacer(modifier = Modifier.padding(top = marginTop))

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(2f)
                    .verticalScroll(rememberScrollState())
            ) {

                InputTextView(
                    hint = "NOMBRE",
                    singleLine = true,
                    isValid = formState.isNameValid.value,
                    selectedValue = viewModel.formGasto.value.name,
                    onValueChange = viewModel::onNameSelected
                )

                InputTextView(
                    hint = "SALDO",
                    singleLine = true,
                    isValid = formState.isSaldoValid.value,
                    selectedValue = viewModel.formGasto.value.saldo,
                    onValueChange = viewModel::onSaldoSelected
                )

                InputTextView(
                    hint = "DESCRIPCION",
                    singleLine = false,
                    isValid = formState.isDescripValid.value,
                    selectedValue = viewModel.formGasto.value.descripcion,
                    onValueChange = viewModel::onDescripSelected
                )
                DatePickerView(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    isValid = formState.isDateValid.value,
                    selectedValue = viewModel.formGasto.value.date,
                    onValueChange = viewModel::onFechaSelected
                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(0.5f),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Bottom
                ) {

                    AcceptButtonView(
                        onAttachImages = { isUploadImage = true },
                        onSaveAndSend = { viewModel.validateForm(id) }) {

                    }

                }

            }


        }
    }

}