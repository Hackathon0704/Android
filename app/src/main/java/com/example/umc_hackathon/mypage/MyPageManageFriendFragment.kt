package com.example.umc_hackathon.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_hackathon.databinding.FragmentMypageManageFriendBinding

class MyPageManageFriendFragment : Fragment() {


    private lateinit var binding: FragmentMypageManageFriendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageManageFriendBinding.inflate(inflater, container, false)
       val friend = listOf(
           Friend("친구1"),
           Friend("친구1"),
           Friend("친구1"),
           Friend("친구1"),
           Friend("친구1"),
       )

        return binding.root
    }

}
