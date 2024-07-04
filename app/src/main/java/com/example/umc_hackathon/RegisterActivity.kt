package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerPwCheckTv.visibility = View.GONE
        binding.registerPwReCheckTv.visibility = View.GONE
        binding.registerNameCheckTv.visibility = View.GONE

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterCheckActivity::class.java))
        }
    }
}