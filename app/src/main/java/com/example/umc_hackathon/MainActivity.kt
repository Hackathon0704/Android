package com.example.umc_hackathon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityMainBinding
import com.example.umc_hackathon.diary.DiaryFragment
import com.example.umc_hackathon.dreamshare.DreamShareFragment
import com.example.umc_hackathon.interpretation.InterpretationFragment
import com.example.umc_hackathon.mypage.MypageFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()

    }

    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, DiaryFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{ item ->
            when (item.itemId) {

                R.id.diary_Fragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, DiaryFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.interpretation_Fragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, InterpretationFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.dreamshare_Fragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, DreamShareFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.mypage_Fragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MypageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}