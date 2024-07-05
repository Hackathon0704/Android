package com.example.umc_hackathon.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.AppData
import com.example.umc_hackathon.databinding.FragmentDiaryBinding

class DiaryFragment : Fragment() {

    lateinit var binding : FragmentDiaryBinding

    override fun onResume() {
        super.onResume()

        if(AppData.isgoMain) {
            binding.dreamLog.visibility = View.VISIBLE
            binding.box.visibility = View.VISIBLE
            binding.diaryNullTv1.visibility = View.GONE
            binding.diaryNullTv2.visibility = View.GONE
            binding.diaryNullTv3.visibility = View.GONE
            binding.diaryNullTv4.visibility = View.GONE
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiaryBinding.inflate(inflater, container, false)


        binding.diaryUserNameTv.text = AppData.user_Name
        binding.diaryNullTv3.text = AppData.user_Name



        return binding.root
    }
}
