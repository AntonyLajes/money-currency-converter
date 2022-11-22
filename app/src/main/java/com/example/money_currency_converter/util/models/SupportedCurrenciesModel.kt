package com.example.money_currency_converter.util.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "supported_currencies")
data class SupportedCurrenciesModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id")
    var id: Int,

    @ColumnInfo(name = "symbol")
    @SerializedName("symbol")
    val symbol: String,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String
)