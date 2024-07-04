package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreamdiaryContentBinding
import com.example.umc_hackathon.databinding.ActivityDreaminterpretationContentBinding

class DreamdiaryContentActivity: AppCompatActivity() {
    lateinit var  binding: ActivityDreamdiaryContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamdiaryContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}