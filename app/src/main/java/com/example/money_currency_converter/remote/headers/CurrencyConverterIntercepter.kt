package com.example.money_currency_converter.remote.headers

import com.example.money_currency_converter.util.constants.ApplicationConstants
import okhttp3.Interceptor
import okhttp3.Response

class CurrencyConverterIntercepter: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader(ApplicationConstants.RAPID_API_KEY.name, ApplicationConstants.RAPID_API_KEY.value)
            .addHeader(ApplicationConstants.RAPID_API_HOST.name, ApplicationConstants.RAPID_API_HOST.value)
            .build()
        return chain.proceed(request)
    }
}