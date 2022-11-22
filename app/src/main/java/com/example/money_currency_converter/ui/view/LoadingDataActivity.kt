package com.example.money_currency_converter.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.isVisible
import com.example.money_currency_converter.R
import com.example.money_currency_converter.databinding.ActivityLoadingDataBinding
import com.example.money_currency_converter.local.SupportedCurrenciesDatabase
import com.example.money_currency_converter.remote.connections.CurrencyConverterEndpoint
import com.example.money_currency_converter.remote.connections.RetrofitClient
import com.example.money_currency_converter.util.models.SupportedCurrenciesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadingDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadingDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(this::viewProgress, 2500)
        Handler(Looper.getMainLooper()).postDelayed(this::viewProgress, 3000)
        Handler(Looper.getMainLooper()).postDelayed(this::viewProgress, 3500)
        Handler(Looper.getMainLooper()).postDelayed(this::getSupportedCurrencies, 3000)
    }

    private fun getSupportedCurrencies() {
        val retrofitClient = RetrofitClient.getRetrofit()
        val endpoint = retrofitClient.create(CurrencyConverterEndpoint::class.java)
        val callback = endpoint.getSupportedCurrencies()

        callback.enqueue(object : Callback<List<SupportedCurrenciesModel>> {
            override fun onResponse(
                call: Call<List<SupportedCurrenciesModel>>,
                response: Response<List<SupportedCurrenciesModel>>
            ) {
                val supportedCurrenciesDb =
                    SupportedCurrenciesDatabase.getSupportedCurrenciesDatabase(this@LoadingDataActivity)
                        .supportedCurrenciesDao()

                if (supportedCurrenciesDb.getAll().isEmpty()) {
                    if (response.code() == 200) {
                        for (country in response.body()!!) {
                            supportedCurrenciesDb.insert(country)
                        }
                    }
                }

                startActivity(Intent(this@LoadingDataActivity, MainActivity::class.java))

            }

            override fun onFailure(call: Call<List<SupportedCurrenciesModel>>, t: Throwable) {
                val s = t.message
            }

        })
    }

    private fun viewProgress(){
        binding.progressDescription.text = binding.progressDescription.text.toString() + "."
    }
}