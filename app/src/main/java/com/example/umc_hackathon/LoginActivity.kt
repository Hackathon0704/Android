package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginIdCheckTv.visibility = View.INVISIBLE
        binding.loginPwCheckTv.visibility = View.INVISIBLE

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }
    }
}