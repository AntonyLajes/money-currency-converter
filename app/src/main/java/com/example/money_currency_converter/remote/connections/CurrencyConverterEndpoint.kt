package com.example.money_currency_converter.remote.connections

import com.example.money_currency_converter.util.models.SupportedCurrenciesModel
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyConverterEndpoint {

    @GET("api/v1/supportedCurrencies")
    fun getSupportedCurrencies(): Call<List<SupportedCurrenciesModel>>

}