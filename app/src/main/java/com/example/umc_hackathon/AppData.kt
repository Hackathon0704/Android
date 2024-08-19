package com.example.umc_hackathon

import android.app.Application

class AppData : Application() {
    companion object {
        // 전역변수
        var user_Name = ""
        var user_Id = 0
        var user_Account = ""
        var isgoMain = false
    }
}