package com.darjnest.gastos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.darjnest.gastos.domain.model.BD.EntradaBD
import com.darjnest.gastos.domain.model.BD.GastoDB

@Database(
    entities = [EntradaBD::class, GastoDB::class],
    version = 1
)

abstract class GastosDatabase : RoomDatabase() {
    abstract fun GastosDao(): GastosDao
}

