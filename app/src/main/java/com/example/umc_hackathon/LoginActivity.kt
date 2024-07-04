package com.example.umc_hackathon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_hackathon.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    lateinit var userAccount: UserAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginIdCheckTv.visibility = View.INVISIBLE
        binding.loginPwCheckTv.visibility = View.INVISIBLE

        binding.loginBtn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val userService = getRetrofit().create(UserInterface::class.java)
        userAccount.account = binding.loginIdEt.text.toString()
        userAccount.password = binding.loginPwEt.text.toString()

        userService.login(userAccount).enqueue(object: Callback<UserResponse<UserLogin>> {
            override fun onResponse(call: Call<UserResponse<UserLogin>>, response: Response<UserResponse<UserLogin>>) {
                Log.d("loign Success", response.toString())
                val resp = response.body()
                if(resp!=null){
                    when(resp.code){
                        "COMMON200"-> {
                            Log.d("loign Result", resp.message)

                            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                            finishAffinity()
                        }
                        else-> {
                            Log.d("loign Result", resp.message)

                            binding.loginIdCheckTv.visibility = View.VISIBLE
                            binding.loginPwCheckTv.visibility = View.VISIBLE
                        }
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse<UserLogin>>, t: Throwable) {
                Log.d("loign Fail", t.message.toString())
            }
        })
    }
}