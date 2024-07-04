package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreamdiaryContentBinding
import com.example.umc_hackathon.databinding.FragmentDiaryBinding

class DreamdiaryContentActivity: AppCompatActivity() {
    lateinit var  binding: ActivityDreamdiaryContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamdiaryContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dreamdiaryCloseIb.setOnClickListener {
            finish()
        }
        binding.dreamdiarySaveTv.setOnClickListener {
            AppData.isgoMain = true
            finish()
        }
    }
}