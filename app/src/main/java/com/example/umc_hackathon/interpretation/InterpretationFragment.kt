package com.example.umc_hackathon.interpretation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_hackathon.DreaminterpretationExpertContentActivity
import com.example.umc_hackathon.InterpretationsFragment
import com.example.umc_hackathon.MainActivity
import com.example.umc_hackathon.MypageDreamInterpretationFragment
import com.example.umc_hackathon.R
import com.example.umc_hackathon.databinding.FragmentDreaminterpretationBinding

class InterpretationFragment : Fragment() {

    private lateinit var binding: FragmentDreaminterpretationBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDreaminterpretationBinding.inflate(inflater, container, false)

        // Dummy data
        val items = listOf(
            InterpretationItem("Title 1", "Content 1", "User 1", "댓글 5"),
            InterpretationItem("Title 2", "Content 2", "User 2", "댓글 3"),
            InterpretationItem("Title 3", "Content 3", "User 3", "댓글 10")
        )

        // Set up RecyclerView
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = InterpretationAdapter(items)
        }

        binding.gotoExpert.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.main_frm, InterpretationsFragment())
                .commitAllowingStateLoss()
        }

        return binding.root
    }
}
