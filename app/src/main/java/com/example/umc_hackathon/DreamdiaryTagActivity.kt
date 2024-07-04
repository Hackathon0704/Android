package com.example.umc_hackathon

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityDreamdiaryTagBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar

class DreamdiaryTagActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDreamdiaryTagBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDreamdiaryTagBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 현재 날짜 받아오기
        var curdate = LocalDate.now()
        var Strdate = curdate.format(DateTimeFormatter.ofPattern("yyyy.mm.dd"))
        binding.tagDateTv.text = Strdate

        // 날짜 변경
        binding.tagDateTv.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                binding.tagDateTv.text = "${year}.${month}.${day}"
            }

            DatePickerDialog(this, data, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}