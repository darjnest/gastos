package com.darjnest.gastos.domain.model

data class Gasto(
    var id_Gasto: String = "",
    var name: String = "",
    var saldo: String = "",
    var date: Long = getDay(),
    var descripcion: String = ""
)


