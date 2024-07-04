package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreaminterpretationContentBinding

class DreaminterpretationContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDreaminterpretationContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreaminterpretationContentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.dreaminterpretationCloseIb.setOnClickListener {
            finish()
        }

        binding.dreaminterpretationSaveTv.setOnClickListener {
            finish()
        }
    }
}
