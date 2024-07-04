package com.example.umc_hackathon.interpretation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentInterpretationBinding

class InterpretationFragment : Fragment() {

    lateinit var binding : FragmentInterpretationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInterpretationBinding.inflate(inflater, container, false)

        return binding.root
    }
}
