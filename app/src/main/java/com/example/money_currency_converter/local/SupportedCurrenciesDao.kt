package com.example.money_currency_converter.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.money_currency_converter.util.models.SupportedCurrenciesModel

@Dao
interface SupportedCurrenciesDao {

    @Query("SELECT * FROM supported_currencies")
    fun getAll(): List<SupportedCurrenciesModel>

    @Query("SELECT * FROM supported_currencies WHERE symbol = :symbol")
    fun getBySymbol(symbol: String): SupportedCurrenciesModel

    @Insert
    fun insert(country: SupportedCurrenciesModel)

    @Query("DELETE FROM supported_currencies")
    fun delete()
}