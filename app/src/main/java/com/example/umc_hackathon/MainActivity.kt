package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

        setFloatingActionButtonListener(DiaryFragment())
    }


    private fun setFloatingActionButtonListener(fragment : Fragment) {
        binding.mainFloatingButton.setOnClickListener {
            when (fragment) {
                is DiaryFragment -> {
                    startActivity(Intent(this, DreamdiaryTagActivity::class.java))
                }
                is InterpretationFragment -> {
                    startActivity(Intent(this, DreaminterpretationContentActivity::class.java))
                }
                is DreamShareFragment -> {
                    startActivity(Intent(this, DreaminterpretationContentActivity::class.java))
                }
                is MypageFragment -> {
                    // 마이페이지 Fragment에서의 특별한 동작
                }
            }
        }

        if (fragment is MypageFragment) {
            binding.mainFloatingButton.visibility = View.GONE
        } else {
            binding.mainFloatingButton.visibility = View.VISIBLE
        }
    }


    private fun initBottomNavigation() {
        // 초기 Fragment 설정
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, DiaryFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.diary_Fragment -> DiaryFragment()
                R.id.interpretation_Fragment -> InterpretationFragment()
                R.id.dreamshare_Fragment -> DreamShareFragment()
                R.id.mypage_Fragment -> MypageFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_frm, it)
                    .commitAllowingStateLoss()
                setFloatingActionButtonListener(it) // Fragment 변경시 FloatingActionButton 리스너 업데이트
                true
            } ?: false
        }
    }
}