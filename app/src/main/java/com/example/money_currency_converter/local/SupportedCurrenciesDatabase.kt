package com.example.money_currency_converter.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.money_currency_converter.util.constants.ApplicationConstants
import com.example.money_currency_converter.util.models.SupportedCurrenciesModel

@Database(entities = [SupportedCurrenciesModel::class], version = 1)
abstract class SupportedCurrenciesDatabase: RoomDatabase() {

    abstract fun supportedCurrenciesDao(): SupportedCurrenciesDao

    companion object{
        private lateinit var INSTANCE: SupportedCurrenciesDatabase

        fun getSupportedCurrenciesDatabase(context: Context): SupportedCurrenciesDatabase{
            if(!::INSTANCE.isInitialized){
                synchronized(context){
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE
        }

        private fun buildDatabase(context: Context): SupportedCurrenciesDatabase{
            return Room.databaseBuilder(context, SupportedCurrenciesDatabase::class.java, ApplicationConstants.SUPPORT_CURRENCIES_DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }

}