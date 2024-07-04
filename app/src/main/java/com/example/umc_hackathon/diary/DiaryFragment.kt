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
