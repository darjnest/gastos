package com.darjnest.gastos.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.darjnest.gastos.domain.model.BD.EntradaBD

@Dao
interface GastosDao{

    // insert Entrada
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntradaAll(entrada : EntradaBD)
}