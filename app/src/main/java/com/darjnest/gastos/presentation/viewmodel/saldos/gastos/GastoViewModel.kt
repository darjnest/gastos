package com.darjnest.gastos.presentation.viewmodel.saldos.gastos

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darjnest.gastos.data.repository.DatabaseRepository
import com.darjnest.gastos.domain.model.BD.GastoDB
import com.darjnest.gastos.domain.model.Gasto
import com.darjnest.gastos.presentation.util.FormValidationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

@HiltViewModel
class GastoViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    val formValidationState = com.darjnest.gastos.presentation.util.FormValidationState()
    val formGasto = mutableStateOf(Gasto())
    val gasto = mutableStateOf(GastoDB())

    fun onNameSelected(value: String) {

        formGasto.value = formGasto.value.copy(name = value)
        formValidationState.ValidateName(formGasto.value.name)
        gasto.value.name = value
    }

    fun onSaldoSelected(value: String) {

        formGasto.value = formGasto.value.copy(saldo = value)
        formValidationState.ValidateSaldo(formGasto.value.saldo)
        gasto.value.name = value
    }

    fun onFechaSelected(value: Long) {
        formGasto.value = formGasto.value.copy(date = value)
        formValidationState.ValidateDate(formGasto.value.date)
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }
        gasto.value.date = formatter.format(value)
    }

    fun onDescripSelected(value: String) {
        formGasto.value = formGasto.value.copy(descripcion = value)
        formValidationState.ValidateDescrp(formGasto.value.descripcion)
        gasto.value.descripcion = value
    }

    fun validateForm(id: String) = viewModelScope.launch {

        formValidationState.ValidateName(formGasto.value.name)
        formValidationState.ValidateSaldo(formGasto.value.saldo)
        formValidationState.ValidateDate(formGasto.value.date)
        formValidationState.ValidateDescrp(formGasto.value.descripcion)

        if (formValidationState.areAllValidationsCorrect()) {

            saveIngreso(id)
        }
    }

    fun saveIngreso(id: String) = viewModelScope.launch {
        gasto.value.id_Gasto = id
        databaseRepository
    }
}