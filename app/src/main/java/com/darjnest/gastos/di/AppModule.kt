package com.darjnest.gastos.di

import android.content.Context
import androidx.room.Room
import com.darjnest.gastos.data.database.GastosDatabase
import com.starconsulting.hallazgo.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        GastosDatabase::class.java,
        Constants.GASTOS_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providesGastosDao(db: GastosDatabase) = db.GastosDao()
}