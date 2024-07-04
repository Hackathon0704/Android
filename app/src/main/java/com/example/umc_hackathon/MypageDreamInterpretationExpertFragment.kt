package com.example.umc_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentDreaminterpretationBinding
import com.example.umc_hackathon.databinding.FragmentMypageDreamInterpretationExoertBinding

class MypageDreamInterpretationExpertFragment : Fragment() {

    lateinit var binding : FragmentMypageDreamInterpretationExoertBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageDreamInterpretationExoertBinding.inflate(inflater, container, false)

        return binding.root
    }
}
