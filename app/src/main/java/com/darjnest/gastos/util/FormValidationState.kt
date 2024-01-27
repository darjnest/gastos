package com.darjnest.gastos.util

import androidx.compose.runtime.mutableStateOf

class FormValidationState{

    var isSaldoValid = mutableStateOf(true)
    var isNameValid = mutableStateOf(true)
    var isDateValid = mutableStateOf(true)
    var isDescripValid = mutableStateOf(true)

    fun ValidateSaldo(value : String){
        isSaldoValid.value = value.isNotEmpty()
    }

    fun ValidateName(value: String){
        isNameValid.value = value.isNotEmpty()
    }

    fun ValidateDate(value : Long){
        isDateValid.value = value != 0L
    }

    fun ValidateDescrp(value: String){
        isDescripValid.value = value.isNotEmpty() && value.length >= 5
    }

    fun areAllValidationsCorrect(): Boolean{
        return isSaldoValid.value &&
                isNameValid.value &&
                isDateValid.value &&
                isDescripValid.value
    }


}