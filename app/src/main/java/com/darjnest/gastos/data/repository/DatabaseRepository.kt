package com.darjnest.gastos.data.repository

import com.darjnest.gastos.data.database.GastosDao
import com.darjnest.gastos.domain.model.BD.EntradaBD
import com.darjnest.gastos.domain.model.BD.GastoDB
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val gastosDao: GastosDao
) {

    suspend fun insertEntrada(Entrada: EntradaBD) = gastosDao.insertEntradaAll(Entrada)

    suspend fun insertGasto(Gasto: GastoDB) = gastosDao.insertGastoAll(Gasto)
}