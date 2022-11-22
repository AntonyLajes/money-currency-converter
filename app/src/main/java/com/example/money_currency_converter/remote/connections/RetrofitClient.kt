package com.example.money_currency_converter.remote.connections

import com.example.money_currency_converter.remote.headers.CurrencyConverterIntercepter
import com.example.money_currency_converter.util.constants.ApplicationConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private lateinit var INSTANCE: Retrofit
        private val client = OkHttpClient.Builder().apply {
            addInterceptor(CurrencyConverterIntercepter())
        }.build()

        fun getRetrofit(): Retrofit {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(ApplicationConstants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE
        }
    }

}