package com.example.umc_hackathon.dreamshare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentDreamshareBinding

class DreamShareFragment : Fragment() {

    lateinit var binding : FragmentDreamshareBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDreamshareBinding.inflate(inflater, container, false)

        return binding.root
    }
}
