package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreamShareContentBinding

class DreamShareContentActivity : AppCompatActivity() {
    lateinit var  binding: ActivityDreamShareContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamShareContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dreamShareCloseIb.setOnClickListener {
            finish()
        }
        binding.dreamShareSaveTv.setOnClickListener {
            finish()
        }
    }
}