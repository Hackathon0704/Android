package com.example.umc_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentDreaminterpretationBinding

class MypageDreamInterpretationFragment : Fragment() {

    lateinit var binding : FragmentDreaminterpretationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDreaminterpretationBinding.inflate(inflater, container, false)

        return binding.root
    }
}
