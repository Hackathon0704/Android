package com.example.umc_hackathon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_hackathon.databinding.FragmentMypageDreamShareFriendBinding
import com.example.umc_hackathon.databinding.FragmentMypageManageFriendBinding

class MypageDreamShareFriendFragment : Fragment() {

    lateinit var binding : FragmentMypageDreamShareFriendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageDreamShareFriendBinding.inflate(inflater, container, false)

        return binding.root
    }
}
