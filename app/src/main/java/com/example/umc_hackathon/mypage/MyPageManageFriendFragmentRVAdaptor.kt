package com.example.umc_hackathon.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_hackathon.R
import com.example.umc_hackathon.databinding.ItemMypageManageFriendBinding

data class Friend(
    val name: String,
)

class MyPageManageFriendFragmentRVAdapter(private val friendList: List<String>) : RecyclerView.Adapter<MyPageManageFriendFragmentRVAdapter.FriendViewHolder>() {

    inner class FriendViewHolder(private val binding: ItemMypageManageFriendBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: String) {
            binding.name.text = friend
            // binding.deleteIv와 binding.deleteTv에 클릭 리스너를 추가할 수 있습니다.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemMypageManageFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.bind(friendList[position])
    }

    override fun getItemCount(): Int {
        return friendList.size
    }
}
