package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityBuyProductBinding

class BuyProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityBuyProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}