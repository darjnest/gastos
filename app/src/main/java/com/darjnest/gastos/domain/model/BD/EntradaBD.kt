package com.darjnest.gastos.domain.model.BD

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Entrada")
data class EntradaBD(
    @PrimaryKey
    @ColumnInfo(name = "Id")
    var id_Entrada : String = "",
    @ColumnInfo(name = "Nombre")
    var name : String = "",
    @ColumnInfo(name = "Saldo")
    var saldo : String = "",
    @ColumnInfo(name = "Fecha")
    var date : String = "",
    @ColumnInfo(name = "Descripcion")
    var descripcion : String = ""


)