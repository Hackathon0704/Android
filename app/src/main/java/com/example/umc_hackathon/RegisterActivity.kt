package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    lateinit var userSignup: UserSignup
    lateinit var checkAccountRequest: CheckAccountRequest

    var ispassDuplicate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userSignup = UserSignup("","","")
        checkAccountRequest = CheckAccountRequest("")

        binding.registerPwCheckTv.visibility = View.INVISIBLE
        binding.registerPwReCheckTv.visibility = View.INVISIBLE
        binding.registerNameCheckTv.visibility = View.INVISIBLE
        binding.registerIdCheckTv.visibility = View.INVISIBLE
        binding.registerFinalCheckTv.visibility = View.INVISIBLE

        binding.registerIdDuplicateTv.visibility = View.INVISIBLE
        binding.registerIdOkayTv.visibility = View.INVISIBLE


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
                binding.registerIdDuplicateTv.visibility = View.INVISIBLE
                binding.registerIdOkayTv.visibility = View.INVISIBLE

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
            if(isCheck1 && isCheck2 && isCheck3 && isCheck4 && ispassDuplicate) {
                join()

                startActivity(Intent(this, RegisterCheckActivity::class.java))
                finish()
            }
            else {
                binding.registerFinalCheckTv.visibility = View.VISIBLE
            }
        }


        binding.registerIdCheckBtn.setOnClickListener {
            check_account()
        }
    }

    private fun join() {
        val userService = getRetrofit().create(UserInterface::class.java)

        userSignup.name = binding.registerNameEt.text.toString()
        userSignup.account = binding.registerIdEt.text.toString()
        userSignup.password = binding.registerPwEt.text.toString()

        userService.join(userSignup).enqueue(object: Callback<UserResponse<UserJoin>> {
            override fun onResponse(
                call: Call<UserResponse<UserJoin>>,
                response: Response<UserResponse<UserJoin>>
            ) {
                Log.d("jion Success", response.toString())
                val resp = response.body()
                if(resp!=null){
                    when(resp.code){
                        "COMMON200"-> {
                            Log.d("jion Result", resp.message)
                        }
                        else-> Log.d("jion Result", resp.message)
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse<UserJoin>>, t: Throwable) {
                Log.d("jion Fail", t.message.toString())
            }
        })
    }

    private fun check_account() {
        val userService = getRetrofit().create(UserInterface::class.java)

        checkAccountRequest.account = binding.registerIdEt.text.toString()

        userService.check_account(checkAccountRequest).enqueue(object: Callback<UserResponse<CheckAccount>> {
            override fun onResponse(
                call: Call<UserResponse<CheckAccount>>,
                response: Response<UserResponse<CheckAccount>>
            ) {
                Log.d("chcek Success", response.toString())
                val resp = response.body()
                if(resp!=null){
                    when(resp.code){
                        "COMMON200"-> {
                            Log.d("chcek Result", resp.message)
                            Log.d("chcek Resultt", resp.result.duplicated.toString())

                            binding.registerIdCheckTv.visibility = View.INVISIBLE

                            if(resp.result.duplicated) {
                                binding.registerIdDuplicateTv.visibility = View.VISIBLE
                                binding.registerIdOkayTv.visibility = View.INVISIBLE
                                ispassDuplicate = false
                            }
                            else {
                                binding.registerIdDuplicateTv.visibility = View.INVISIBLE
                                binding.registerIdOkayTv.visibility = View.VISIBLE
                                ispassDuplicate = true
                            }

                        }
                        else-> Log.d("chcek Result", resp.message)
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse<CheckAccount>>, t: Throwable) {
                Log.d("chcek Fail", t.message.toString())
            }
        })
    }
}