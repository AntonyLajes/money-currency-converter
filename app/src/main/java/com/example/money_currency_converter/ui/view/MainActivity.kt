package com.example.money_currency_converter.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.money_currency_converter.R
import com.example.money_currency_converter.databinding.ActivityMainBinding
import com.example.money_currency_converter.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setContentView(binding.root)
        initSpinners()
        observers()
    }

    private fun observers(){
        mainViewModel.countryCurrencies.observe(this, Observer{
            val adapter = ArrayAdapter(this, R.layout.spinner_item, it)
            binding.includeContentMain.fromSpinner.adapter = adapter
            binding.includeContentMain.toSpinner.adapter = adapter
        })
    }

    private fun initSpinners(){
        mainViewModel.getCountriesCurrencies()
    }
}