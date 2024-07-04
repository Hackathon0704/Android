package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityBuyProductBinding
import com.example.umc_hackathon.databinding.ActivityDreaminterpretationExpertContentBinding

class DreaminterpretationExpertContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDreaminterpretationExpertContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreaminterpretationExpertContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dreaminterpretationExpertSaveTv.setOnClickListener {
            startActivity(Intent(this, BuyProductActivity::class.java))
           finish()
        }

        binding.dreaminterpretationExpertCloseIb.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
