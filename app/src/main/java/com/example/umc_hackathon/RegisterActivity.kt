package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityRegisterBinding
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerPwCheckTv.visibility = View.INVISIBLE
        binding.registerPwReCheckTv.visibility = View.INVISIBLE
        binding.registerNameCheckTv.visibility = View.INVISIBLE
        binding.registerIdCheckTv.visibility = View.INVISIBLE
        binding.registerFinalCheckTv.visibility = View.INVISIBLE


        var isCheck1 = false
        var isCheck2 = false
        var isCheck3 = false
        var isCheck4 = false
        binding.registerNameEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 이름 유효성 검사
                val nickPattern = "^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9]{1,8}$"   // 영문, 한글, 숫자 1~8자
                val pattern = Pattern.compile(nickPattern)
                val matcher = pattern.matcher(binding.registerNameEt.text)

                val isNick = matcher.find()
                if(isNick) {
                    binding.registerNameCheckTv.visibility = View.INVISIBLE
                    isCheck1 = true
                }
                else {
                    binding.registerNameCheckTv.visibility = View.VISIBLE
                    isCheck1 = false
                }
            }
        })

        binding.registerIdEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 닉네임 유효성 검사
                val nickPattern = "^[a-zA-Z0-9]{5,15}$"   // 영문, 숫자 5~15자
                val pattern = Pattern.compile(nickPattern)
                val matcher = pattern.matcher(binding.registerIdEt.text)

                val isNick = matcher.find()
                if(isNick) {
                    binding.registerIdCheckTv.visibility = View.INVISIBLE
                    isCheck2 = true
                }
                else {
                    binding.registerIdCheckTv.visibility = View.VISIBLE
                    isCheck2 = false
                }
            }
        })

        binding.registerPwEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 비밀번호 유효성 검사
                val nickPattern = "^[a-zA-Z0-9]{1,}$"   // 영문, 숫자 1자 이상
                val pattern = Pattern.compile(nickPattern)
                val matcher = pattern.matcher(binding.registerPwEt.text)

                val isNick = matcher.find()
                if(isNick) {
                    binding.registerPwCheckTv.visibility = View.INVISIBLE
                    isCheck3 = true
                }
                else {
                    binding.registerPwCheckTv.visibility = View.VISIBLE
                    isCheck3 = false
                }
            }
        })

        binding.registerPwReEt.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // 비밀번호 유효성 검사
                if(binding.registerPwEt.text.toString().equals(binding.registerPwReEt.text.toString())) {
                    binding.registerPwReCheckTv.visibility = View.INVISIBLE
                    isCheck4 = true
                }
                else {
                    binding.registerPwReCheckTv.visibility = View.VISIBLE
                    isCheck4 = false
                }
            }
        })

        binding.registerBtn.setOnClickListener {
            if(isCheck1 && isCheck2 && isCheck3 && isCheck4) {
                startActivity(Intent(this, RegisterCheckActivity::class.java))
                finish()
            }
            else {
                binding.registerFinalCheckTv.visibility = View.VISIBLE
            }
        }
    }
}