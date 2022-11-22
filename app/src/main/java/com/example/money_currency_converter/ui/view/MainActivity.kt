package com.example.money_currency_converter.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.money_currency_converter.R
import com.example.money_currency_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}