package com.example.money_currency_converter.util.constants

import com.example.money_currency_converter.util.models.HeaderModel

class ApplicationConstants {

    companion object{
        val BASE_URL = "https://currency-converter18.p.rapidapi.com/"
        val RAPID_API_KEY = HeaderModel("X-RapidAPI-Key", "7ea476117fmsh8f9bc9c1d47b127p109bdcjsne35f515fc219")
        val RAPID_API_HOST = HeaderModel("X-RapidAPI-Host", "currency-converter18.p.rapidapi.com")
        val SUPPORT_CURRENCIES_DB_NAME = "supported_currencies"
    }

}