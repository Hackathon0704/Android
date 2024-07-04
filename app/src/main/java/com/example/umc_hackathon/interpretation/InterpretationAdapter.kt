package com.example.umc_hackathon.interpretation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_hackathon.databinding.ItemDreamInterpretationBinding

class InterpretationAdapter(private val items: List<InterpretationItem>) : RecyclerView.Adapter<InterpretationAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemDreamInterpretationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InterpretationItem) {
            binding.title.text = item.title
            binding.content.text = item.content
            binding.id.text = item.userId
            binding.comment.text = item.commentCount
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDreamInterpretationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

data class InterpretationItem(val title: String, val content: String, val userId: String, val commentCount: String)
