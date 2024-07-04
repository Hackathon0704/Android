package com.example.umc_hackathon

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.content.Intent
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

        // 날짜 변경
        binding.tagDateTv.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                binding.tagDateTv.text = "${year}.${month + 1}.${day}"
            }

            DatePickerDialog(this, data, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // 취침시간변경
        binding.tagSleepTimeCl.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.tagSleepTimeTv2.text = "${hourOfDay}:${minute}"
            }

            TimePickerDialog(this, data, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true).show()
        }

        // 기상시간변경
        binding.tagWakeTimeCl.setOnClickListener {
            val cal = Calendar.getInstance()
            val data = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                binding.tagWakeTimeTv2.text = "${hourOfDay}:${minute}"
            }

            TimePickerDialog(this, data, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true).show()
        }



        binding.tagExitIv.setOnClickListener {
           finish()
        }
        binding.tagNextTv.setOnClickListener {
            val intent = Intent(this, DreamdiaryContentActivity::class.java)
            startActivity(intent)
        }
    }
}