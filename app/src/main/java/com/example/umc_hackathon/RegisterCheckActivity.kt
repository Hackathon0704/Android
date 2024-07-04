package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityRegisterCheckBinding

class RegisterCheckActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerCheckBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }

}