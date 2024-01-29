package com.darjnest.gastos.presentation.viewmodel.saldos.entrada

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darjnest.gastos.data.repository.DatabaseRepository
import com.darjnest.gastos.domain.model.BD.EntradaBD
import com.darjnest.gastos.domain.model.Entrada
import com.darjnest.gastos.presentation.util.FormValidationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

@HiltViewModel
class EntradaViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository

) : ViewModel() {

    val formValidationState = com.darjnest.gastos.presentation.util.FormValidationState()
    val formEntrada = mutableStateOf(Entrada())
    val ingreso = mutableStateOf(EntradaBD())

    fun onNameSelected(value: String) {

        formEntrada.value = formEntrada.value.copy(name = value)
        formValidationState.ValidateName(formEntrada.value.name)
        ingreso.value.name = value

    }

    fun onSaldoSelected(value: String) {
        formEntrada.value = formEntrada.value.copy(saldo = value)
        formValidationState.ValidateSaldo((formEntrada.value.saldo))
        ingreso.value.saldo = value
    }

    fun onFechaSelected(value: Long) {
        formEntrada.value = formEntrada.value.copy(date = value)
        formValidationState.ValidateDate((formEntrada.value.date))
        val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }
        ingreso.value.date = formatter.format(value)
    }

    fun onDescripSelected(value: String) {
        formEntrada.value = formEntrada.value.copy(descripcion = value)
        formValidationState.ValidateDescrp((formEntrada.value.descripcion))
        ingreso.value.descripcion = value
    }

    fun validateForm(id: String) = viewModelScope.launch {

        formValidationState.ValidateName(formEntrada.value.name)
        formValidationState.ValidateSaldo(formEntrada.value.saldo)
        formValidationState.ValidateDate(formEntrada.value.date)
        formValidationState.ValidateDescrp(formEntrada.value.descripcion)

        if (formValidationState.areAllValidationsCorrect()) {
            saveIngreso(id)
        }
    }

    fun saveIngreso(id: String) = viewModelScope.launch {

        ingreso.value.id_Entrada = id
        databaseRepository.insertEntrada(ingreso.value)


    }


}

