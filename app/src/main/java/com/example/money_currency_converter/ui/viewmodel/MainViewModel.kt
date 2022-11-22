package com.example.money_currency_converter.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.money_currency_converter.local.SupportedCurrenciesDatabase

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val database = SupportedCurrenciesDatabase.getSupportedCurrenciesDatabase(application).supportedCurrenciesDao()
    private var _countryCurrencies: MutableLiveData<List<String>> = MutableLiveData()
    val countryCurrencies: LiveData<List<String>> get() = _countryCurrencies

    fun getCountriesCurrencies(){
        val currencies: MutableList<String> = mutableListOf()
        for (countriesCurrencies in database.getAll()){
            currencies.add(countriesCurrencies.symbol + " - " + countriesCurrencies.name)
        }
        _countryCurrencies.value = currencies
    }

}