package com.example.umc_hackathon.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.MainActivity
import com.example.umc_hackathon.MypageDreamInterpretationExpertFragment
import com.example.umc_hackathon.MypageDreamInterpretationFragment
import com.example.umc_hackathon.MypageDreamShareFriendFragment
import com.example.umc_hackathon.MypageManageFriendFragment
import com.example.umc_hackathon.R
import com.example.umc_hackathon.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {

    lateinit var binding : FragmentMypageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageBinding.inflate(inflater, container, false)


        binding.manageTv1.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MypageManageFriendFragment())
                    .commitAllowingStateLoss()
        }

        binding.manageTv2.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MypageDreamInterpretationFragment())
                .commitAllowingStateLoss()
        }

        binding.manageTv3.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MypageDreamInterpretationExpertFragment())
                .commitAllowingStateLoss()
        }

        binding.manageTv4.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, MypageDreamShareFriendFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }
}
