package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentInterpretationsBinding

class InterpretationsFragment : Fragment() {
    lateinit var binding : FragmentInterpretationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInterpretationsBinding.inflate(inflater, container, false)

        binding.maru.setOnClickListener {

            val intent = Intent(requireContext(), DreaminterpretationExpertContentActivity::class.java)
            startActivity(intent)
        }



        return binding.root
    }
}