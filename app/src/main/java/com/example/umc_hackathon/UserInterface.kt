package com.example.umc_hackathon

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInterface {
    @POST("/user/login")
    fun login(
        @Body userAccount: UserAccount
    ): Call<UserResponse<UserLogin>>

    @POST("/user/join")
    fun join(
        @Body userSignup: UserSignup
    ): Call<UserResponse<UserJoin>>
}