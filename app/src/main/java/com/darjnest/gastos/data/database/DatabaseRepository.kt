package com.darjnest.gastos.data.database

import com.darjnest.gastos.domain.model.BD.EntradaBD
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val gastosDao: GastosDao
){

    suspend fun insertEntrada(Entrada : EntradaBD) = gastosDao.insertEntradaAll(Entrada)
}