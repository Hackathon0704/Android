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
    private lateinit var adapter: MyPageManageFriendFragmentRVAdapter
    private val friendList = listOf("친구 1", "친구 2", "친구 3") // 예시 데이터




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMypageManageFriendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = MyPageManageFriendFragmentRVAdapter(friendList)
        binding.friendRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.friendRecyclerView.adapter = adapter
    }
}
