package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreamdiaryTagBinding

class DreamdiaryTagActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDreamdiaryTagBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamdiaryTagBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}