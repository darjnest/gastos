package com.darjnest.gastos.domain.model

import java.util.Calendar

data class Entrada(

    var id_Entrada: String = "",
    var name: String = "",
    var saldo: String = "",
    var date: Long = getDay(),
    var descripcion: String = ""
)

fun getDay(): Long {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    return calendar.timeInMillis
}

